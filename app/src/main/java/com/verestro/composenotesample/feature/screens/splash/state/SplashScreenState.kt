package com.verestro.composenotesample.feature.screens.splash.state

sealed class SplashScreenState {
    object Idle : SplashScreenState()
    data class BottomSheetExpanded(val isExpanded: Boolean) : SplashScreenState()
}