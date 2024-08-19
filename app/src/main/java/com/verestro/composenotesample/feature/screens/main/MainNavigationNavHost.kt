package com.verestro.composenotesample.feature.screens.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.verestro.composenotesample.data.model.Category
import com.verestro.composenotesample.feature.screens.main.categories.details.CategoryDetailsViewModel
import com.verestro.composenotesample.feature.screens.main.categories.preview.presentation.CategoriesScreen
import com.verestro.composenotesample.feature.screens.main.categories.details.presentation.CategoryDetailsScreen
import com.verestro.composenotesample.feature.screens.main.categories.details.presentation.mvi.CategoryDetailsIntent
import com.verestro.composenotesample.feature.screens.main.categories.preview.presentation.CategoriesViewModel
import com.verestro.composenotesample.feature.screens.main.categories.preview.presentation.mvi.intent.CategoriesIntent
import com.verestro.composenotesample.feature.screens.main.menu.MenuNavigationRoutes
import com.verestro.composenotesample.feature.screens.main.payment.PaymentInfoScreen
import com.verestro.composenotesample.feature.screens.main.payment.PaymentInfoViewModel
import com.verestro.composenotesample.feature.screens.main.payment.mvi.PaymentInfoIntent
import com.verestro.composenotesample.feature.screens.main.shopping.menu.MenuShoppingCartScreen
import com.verestro.composenotesample.feature.screens.main.shopping.menu.MenuShoppingCartScreenViewModel
import com.verestro.composenotesample.feature.screens.main.shopping.menu.mvi.MenuShoppingCartIntent
import com.verestro.composenotesample.navigation.NavigationRoutes

@Composable
fun MainNavigationNavHost(
    menuNavController: NavHostController,
    appNavController: NavController
) {
    NavHost(
        navController = menuNavController,
        startDestination = MenuNavigationRoutes.MENU_CATEGORIES_SCREEN_ROUTE
    ) {

        composable(MenuNavigationRoutes.MENU_CATEGORIES_SCREEN_ROUTE) {
            val viewModel: CategoriesViewModel = hiltViewModel()
            val state by viewModel.state.collectAsState()

            LocalLifecycleOwner.current.let { lifecycleOwner ->
                DisposableEffect(lifecycleOwner) {
                    lifecycleOwner.lifecycle.addObserver(viewModel)
                    onDispose { lifecycleOwner.lifecycle.removeObserver(viewModel) }
                }
            }

            CategoriesScreen(
                state = state,
                onSetIdle = {
                    viewModel.handleIntent(intent = CategoriesIntent.SetIdle)
                },
                onNavigateToCategory = { category ->
                    viewModel.handleIntent(intent = CategoriesIntent.NavigateToCategory(category = category))
                },
                onSearchCategories = { searchPredicate ->
                    viewModel.handleIntent(intent = CategoriesIntent.SearchCategory(searchPredicate = searchPredicate))
                },
                onAppNavigateTo = { route ->
                    appNavController.navigate(route = route)
                },
                onMenuNavigateTo = { route ->
                    menuNavController.navigate(route = route)
                }
            )
        }

        composable(
            route = MenuNavigationRoutes.MENU_CATEGORIES_DETAILS_SCREEN,
            arguments = listOf(navArgument("category") { type = NavType.StringType })
        ) { backStackEntry ->
            val categoryString = backStackEntry.arguments?.getString("category")
            val category = Category.valueOf(categoryString ?: Category.VEGETABLES.name)
            val viewModel: CategoryDetailsViewModel = hiltViewModel()
            val state by viewModel.state.collectAsState()

            CategoryDetailsScreen(
                category = category,
                state = state,
                onAppNavigateTo = { route ->
                    appNavController.navigate(route = route)
                },
                onSetIdle = {
                    viewModel.handleIntent(intent = CategoryDetailsIntent.SetIdle)
                },
                onNavigateToItemDetailsClicked = {
                    viewModel.handleIntent(intent = CategoryDetailsIntent.NavigateToItemDetails)
                }
            )
        }

        composable(MenuNavigationRoutes.MENU_SHOPPING_CART_SCREEN_ROUTE) {
            val viewModel: MenuShoppingCartScreenViewModel = hiltViewModel()
            val state by viewModel.state.collectAsState()
            MenuShoppingCartScreen(
                state = state,
                onNavigateToPaymentInfoClicked = {
                    appNavController.navigate(route = NavigationRoutes.PAYMENT_CARD_INFO_SCREEN_ROUTE)
                },
                onSetIdle = {
                    viewModel.handleIntent(intent = MenuShoppingCartIntent.SetIdle)
                }
            )
        }
    }
}