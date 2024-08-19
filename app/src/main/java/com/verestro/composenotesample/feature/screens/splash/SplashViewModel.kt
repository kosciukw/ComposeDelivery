package com.verestro.composenotesample.feature.screens.splash

import com.verestro.composenotesample.commons.base.BaseViewModel
import com.verestro.composenotesample.feature.screens.splash.intent.SplashScreenIntent
import com.verestro.composenotesample.feature.screens.splash.state.SplashScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor() : BaseViewModel() {

    private val _state = MutableStateFlow<SplashScreenState>(SplashScreenState.Idle)
    val state: StateFlow<SplashScreenState> = _state

    init {
        _state.value = SplashScreenState.BottomSheetExpanded(isExpanded = true)
    }

    fun handleIntent(intent: SplashScreenIntent) {
        when (intent) {
            is SplashScreenIntent.ExpandBottomSheet -> expandBottomSheet(isExpanded = intent.stateExpanded)
            SplashScreenIntent.Idle -> setIdle()
        }
    }

    private fun setIdle() {
        _state.value = SplashScreenState.Idle
    }

    private fun expandBottomSheet(isExpanded: Boolean) {
        _state.value = SplashScreenState.BottomSheetExpanded(isExpanded = isExpanded)
    }
}