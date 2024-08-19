package com.verestro.composenotesample.feature.screens.main.categories.details.presentation.mvi

sealed class CategoryDetailsIntent {
    object SetIdle : CategoryDetailsIntent()
    object NavigateToItemDetails : CategoryDetailsIntent()
}