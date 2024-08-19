package com.verestro.composenotesample.feature.screens.main.categories.preview.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.viewModelScope
import com.verestro.composenotesample.commons.base.BaseViewModel
import com.verestro.composenotesample.data.model.Category
import com.verestro.composenotesample.data.usecase.SearchCategoriesUseCase
import com.verestro.composenotesample.data.usecase.GetCategoriesUseCase
import com.verestro.composenotesample.feature.screens.main.categories.preview.presentation.mvi.intent.CategoriesIntent
import com.verestro.composenotesample.feature.screens.main.categories.preview.presentation.mvi.state.CategoriesState
import com.verestro.composenotesample.feature.screens.main.menu.MenuNavigationRoutes
import com.verestro.composenotesample.feature.screens.main.menu.MenuNavigationRoutes.CATEGORY_ARGUMENT
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class CategoriesViewModel @Inject constructor(
    private val getCategoriesUseCase: GetCategoriesUseCase,
    private val searchCategoriesUseCase: SearchCategoriesUseCase
) : BaseViewModel() {

    private val _state = MutableStateFlow<CategoriesState>(CategoriesState.Idle)
    val state: StateFlow<CategoriesState> = _state

    override fun onResume(owner: LifecycleOwner) {
        handleIntent(CategoriesIntent.GetCategories)
    }

    fun handleIntent(intent: CategoriesIntent) {
        when (intent) {
            is CategoriesIntent.NavigateToCategory -> navigateToCategory(category = intent.category)
            is CategoriesIntent.SearchCategory -> searchCategories(predicate = intent.searchPredicate)
            is CategoriesIntent.SetIdle -> setIdle()
            is CategoriesIntent.GetCategories -> getCategories()
        }
    }

    private fun setIdle() {
        _state.value = CategoriesState.Idle
    }

    private fun navigateToCategory(category: Category) {
        when (category) {
            Category.VEGETABLES -> {
                val route = MenuNavigationRoutes.MENU_CATEGORIES_DETAILS_SCREEN
                    .replace(
                        oldValue = CATEGORY_ARGUMENT,
                        newValue = category.name
                    )
                _state.value = CategoriesState.Navigation.MenuNavigation(route = route)

            }

            else -> {
                //no-operation
            }
        }
    }

    private fun searchCategories(predicate: String) {
        searchCategoriesUseCase(
            params = predicate,
            viewModelScope = viewModelScope
        ) { result ->
            result.onSuccess { categories ->
                categories?.let {
                    _state.value =
                        CategoriesState.DisplayCategories(
                            categories = categories,
                            isLoading = false
                        )
                }
            }
            result.onFailure { error -> error.printStackTrace() }
        }

    }

    private fun getCategories() {
        getCategoriesUseCase(
            params = Unit,
            viewModelScope = viewModelScope
        ) { result ->
            result.onSuccess { categories ->
                categories?.let {
                    _state.value =
                        CategoriesState.DisplayCategories(
                            categories = categories,
                            isLoading = false
                        )
                }
            }
            result.onFailure { error -> error.printStackTrace() }
        }
    }
}