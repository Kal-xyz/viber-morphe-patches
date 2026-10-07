package app.morphe.patches.viber.ui

import app.morphe.patcher.Fingerprint

internal object BottomNavigationInitFingerprint : Fingerprint(
    returnType = "V",
    parameters = listOf("Landroid/view/Menu;"),
    strings = listOf("menu_explore", "nav_explore")
)
