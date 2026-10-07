package app.morphe.patches.viber.ui

import app.morphe.patcher.extensions.InstructionExtensions.addInstructions
import app.morphe.patcher.patch.bytecodePatch
import app.morphe.patches.viber.shared.Constants.COMPATIBILITY_VIBER

private const val EXTENSION_CLASS = "Lapp/morphe/extension/viber/UiHook;"

@Suppress("unused")
val cleanUiPatch = bytecodePatch(
    name = "Clean UI",
    description = "Removes the Explore tab and promotional badges from bottom navigation."
) {
    compatiblePackages(COMPATIBILITY_VIBER)

    execute {
        BottomNavigationInitFingerprint.result?.let { match ->
            val method = match.method
            method.addInstructions(
                0,
                """
                invoke-static {}, $EXTENSION_CLASS->isExploreTabEnabled()Z
                move-result v0
                if-nez v0, :cond_explore
                return-void
                :cond_explore
                """
            )
        }
    }
}
