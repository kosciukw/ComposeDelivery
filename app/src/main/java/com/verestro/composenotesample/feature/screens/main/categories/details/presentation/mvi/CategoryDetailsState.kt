package com.verestro.composenotesample.feature.screens.main.categories.details.presentation.mvi

sealed class CategoryDetailsState {

    object Idle : CategoryDetailsState()

    data class Navigation(val route: String) : CategoryDetailsState()
}