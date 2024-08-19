package com.verestro.composenotesample.feature.screens.splash.intent


sealed class SplashScreenIntent {
    object Idle : SplashScreenIntent()
    data class ExpandBottomSheet(val stateExpanded: Boolean) : SplashScreenIntent()
}