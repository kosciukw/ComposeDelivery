package com.verestro.composenotesample.feature.screens.main.categories.details

import androidx.lifecycle.ViewModel
import com.verestro.composenotesample.feature.screens.main.categories.details.presentation.mvi.CategoryDetailsIntent
import com.verestro.composenotesample.feature.screens.main.categories.details.presentation.mvi.CategoryDetailsState
import com.verestro.composenotesample.navigation.NavigationRoutes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class CategoryDetailsViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableStateFlow<CategoryDetailsState>(CategoryDetailsState.Idle)
    val state: StateFlow<CategoryDetailsState> = _state

    fun handleIntent(intent: CategoryDetailsIntent) {
        when (intent) {
            CategoryDetailsIntent.SetIdle -> setIdle()
            CategoryDetailsIntent.NavigateToItemDetails -> navigateToItemDetails()
        }
    }

    private fun setIdle() {
        _state.value = CategoryDetailsState.Idle
    }

    private fun navigateToItemDetails() {
        _state.value = CategoryDetailsState.Navigation(route = NavigationRoutes.SHOPPING_CARD_ITEM_DETAILS_SCREEN_ROUTE)
    }
}