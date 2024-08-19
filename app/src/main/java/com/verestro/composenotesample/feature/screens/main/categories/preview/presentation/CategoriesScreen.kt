package com.verestro.composenotesample.feature.screens.main.categories.preview.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.verestro.composenotesample.R
import com.verestro.composenotesample.commons.ui.components.search.SearchBar
import com.verestro.composenotesample.commons.ui.components.spacers.SpacerM
import com.verestro.composenotesample.commons.ui.text.styles.TextPrimary
import com.verestro.composenotesample.data.model.Category
import com.verestro.composenotesample.data.model.CategoryUi
import com.verestro.composenotesample.feature.screens.main.categories.preview.presentation.components.CategoryCard
import com.verestro.composenotesample.feature.screens.main.categories.preview.presentation.mvi.state.CategoriesState
import com.verestro.composenotesample.ui.theme.ColorBackgroundMenuScreens
import com.verestro.composenotesample.utils.extensions.empty

@Composable
fun CategoriesScreen(
    state: CategoriesState,
    onAppNavigateTo: (route: String) -> Unit,
    onMenuNavigateTo: (route: String) -> Unit,
    onNavigateToCategory: (category: Category) -> Unit,
    onSearchCategories: (searchText: String) -> Unit,
    onSetIdle: () -> Unit
) {

    var searchText by remember { mutableStateOf(String.empty()) }
    var categories by remember { mutableStateOf(listOf<CategoryUi>()) }
    var showProgressBar by remember { mutableStateOf(true) }

    LaunchedEffect(state) {
        when (state) {
            CategoriesState.Idle -> Unit
            is CategoriesState.Navigation.MenuNavigation -> {
                onMenuNavigateTo(state.route)
                onSetIdle()
            }

            is CategoriesState.Navigation.AppNavigation -> {
                onAppNavigateTo(state.route)
                onSetIdle()
            }

            is CategoriesState.DisplayCategories -> {
                categories = state.categories
                showProgressBar = state.isLoading
                onSetIdle()
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = ColorBackgroundMenuScreens)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = stringResource(id = R.string.categories_screen_header),
            style = TextPrimary
        )
        SpacerM()
        SearchBar(
            hint = stringResource(id = R.string.menu_screen_search),
            text = searchText,
            onTextChange = { newText ->
                searchText = newText
                onSearchCategories(searchText)
            }
        )

        SpacerM()

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (showProgressBar) CircularProgressIndicator()
            else CategoriesGrid(categories) { category -> onNavigateToCategory(category) }
        }
    }
}

@Composable
private fun CategoriesGrid(
    categories: List<CategoryUi>,
    onCategoryClicked: (Category) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 150.dp),
        modifier = Modifier
            .heightIn(max = 800.dp)
            .fillMaxWidth(),
        userScrollEnabled = false
    ) {
        items(categories) { categoryUi ->
            CategoryCard(categoryUi = categoryUi) { category -> onCategoryClicked(category) }
        }
    }
}