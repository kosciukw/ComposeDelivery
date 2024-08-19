package com.verestro.composenotesample.feature.screens.main.categories.preview.presentation.mvi.intent

import com.verestro.composenotesample.data.model.Category

sealed class CategoriesIntent {
    object SetIdle : CategoriesIntent()
    object GetCategories : CategoriesIntent()
    data class NavigateToCategory(val category: Category) : CategoriesIntent()
    data class SearchCategory(val searchPredicate: String) : CategoriesIntent()
}