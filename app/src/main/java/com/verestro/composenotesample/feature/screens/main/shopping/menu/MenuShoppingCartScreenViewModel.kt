package com.verestro.composenotesample.feature.screens.main.shopping.menu

import androidx.lifecycle.ViewModel
import com.verestro.composenotesample.commons.base.BaseViewModel
import com.verestro.composenotesample.feature.screens.main.categories.details.presentation.mvi.CategoryDetailsIntent
import com.verestro.composenotesample.feature.screens.main.categories.details.presentation.mvi.CategoryDetailsState
import com.verestro.composenotesample.feature.screens.main.menu.MenuNavigationRoutes
import com.verestro.composenotesample.feature.screens.main.shopping.menu.mvi.MenuShoppingCartIntent
import com.verestro.composenotesample.feature.screens.main.shopping.menu.mvi.MenuShoppingCartState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class MenuShoppingCartScreenViewModel @Inject constructor() : BaseViewModel() {

    private val _state = MutableStateFlow<MenuShoppingCartState>(MenuShoppingCartState.Idle)
    val state: StateFlow<MenuShoppingCartState> = _state

    fun handleIntent(intent: MenuShoppingCartIntent) {
        when (intent) {
            MenuShoppingCartIntent.SetIdle -> setIdle()
//            MenuShoppingCartIntent.NavigateToItemDetails -> navigateToItemDetails()
        }
    }

    private fun setIdle() {
        _state.value = MenuShoppingCartState.Idle
    }

    private fun navigateToItemDetails() {
//        _state.value = MenuShoppingCartState.Navigation(route = MenuNavigationRoutes.SHOPPING_CARD_ITEM_DETAILS)
    }
}