package com.verestro.composenotesample.feature.screens.main.categories.preview.presentation.mvi.state

import com.verestro.composenotesample.data.model.CategoryUi

sealed class CategoriesState {

    object Idle : CategoriesState()

    data class DisplayCategories(
        val categories: List<CategoryUi>,
        val isLoading: Boolean
    ) : CategoriesState()

    sealed class Navigation : CategoriesState() {
        data class MenuNavigation(val route: String) : Navigation()
        data class AppNavigation(val route: String) : Navigation()
    }
}