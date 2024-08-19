package com.verestro.composenotesample.feature.screens.main.shopping.menu.mvi

sealed class MenuShoppingCartState {

    object Idle : MenuShoppingCartState()

//    data class Navigation(val route: String) : MenuShoppingCartState()
}