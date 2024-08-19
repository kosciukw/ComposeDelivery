package com.verestro.composenotesample.feature.screens.main.shopping.menu.mvi

sealed class MenuShoppingCartIntent {
    object SetIdle : MenuShoppingCartIntent()
//    object NavigateToItemDetails : MenuShoppingCartIntent()
}