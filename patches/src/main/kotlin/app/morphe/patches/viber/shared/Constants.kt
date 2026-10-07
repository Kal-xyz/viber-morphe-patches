package app.morphe.patches.viber.shared

object Constants {
    const val PACKAGE_VIBER = "com.viber.voip"

    // Compatibility target: Viber on Android (all versions or specify minimum tested)
    val COMPATIBILITY_VIBER = listOf(
        PACKAGE_VIBER to setOf<String>()
    )
}
