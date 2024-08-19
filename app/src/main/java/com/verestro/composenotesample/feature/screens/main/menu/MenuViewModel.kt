package com.verestro.composenotesample.feature.screens.main.menu

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MenuViewModel @Inject constructor() : ViewModel() {

    private val _menuNavigationItems = MutableStateFlow(
        listOf(
            MenuNavigationItem.Categories,
            MenuNavigationItem.ShoppingCart,
            MenuNavigationItem.PersonalInfo
        )
    )
    val menuNavigationItems = _menuNavigationItems.asStateFlow()

}