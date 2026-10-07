package app.morphe.patches.viber.ad

import app.morphe.patcher.extensions.InstructionExtensions.addInstructions
import app.morphe.patcher.patch.bytecodePatch
import app.morphe.patches.viber.shared.Constants.COMPATIBILITY_VIBER

private const val EXTENSION_CLASS = "Lapp/morphe/extension/viber/AdBlockHook;"

@Suppress("unused")
val hideAdsPatch = bytecodePatch(
    name = "Hide ads",
    description = "Removes in-chat banner ads, explore ads, and call-end promotional cards."
) {
    compatiblePackages(COMPATIBILITY_VIBER)

    execute {
        // Intercept ad loader to suppress ad queries
        ViberAdLoaderFingerprint.result?.let { match ->
            val method = match.method
            method.addInstructions(
                0,
                """
                const/4 v0, 0x0
                return v0
                """
            )
        }

        // Intercept banner container inflation to hide view
        ViberBannerViewFingerprint.result?.let { match ->
            val method = match.method
            method.addInstructions(
                0,
                """
                invoke-static {p1}, $EXTENSION_CLASS->hideAdView(Landroid/view/View;)V
                """
            )
        }
    }
}
