package com.verestro.composenotesample.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.verestro.composenotesample.navigation.NavigationRoutes.MAIN_SCREEN_ROUTE
import com.verestro.composenotesample.navigation.NavigationRoutes.SPLASH_SCREEN_ROUTE
import com.verestro.composenotesample.feature.screens.main.MainScreen
import com.verestro.composenotesample.feature.screens.main.menu.MenuNavigationRoutes
import com.verestro.composenotesample.feature.screens.main.payment.PaymentInfoScreen
import com.verestro.composenotesample.feature.screens.main.payment.PaymentInfoViewModel
import com.verestro.composenotesample.feature.screens.main.payment.mvi.PaymentInfoIntent
import com.verestro.composenotesample.feature.screens.main.shopping.details.ShoppingCartDetailsScreen
import com.verestro.composenotesample.feature.screens.splash.SplashScreen
import com.verestro.composenotesample.feature.screens.splash.SplashViewModel
import com.verestro.composenotesample.feature.screens.splash.intent.SplashScreenIntent
import com.verestro.composenotesample.navigation.NavigationRoutes.PAYMENT_CARD_INFO_SCREEN_ROUTE
import com.verestro.composenotesample.navigation.NavigationRoutes.SHOPPING_CARD_ITEM_DETAILS_SCREEN_ROUTE

@Composable
fun AppNavigationNavHost() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = SPLASH_SCREEN_ROUTE
    ) {
        composable(SPLASH_SCREEN_ROUTE) {
            val viewModel: SplashViewModel = hiltViewModel()
            val state by viewModel.state.collectAsState()

            SplashScreen(
                state = state,
                onNavigateToMainScreen = {
                    navController.navigate(MAIN_SCREEN_ROUTE)
                },
                onExpandBottomSheet = { stateExpanded ->
                    viewModel.handleIntent(
                        intent = SplashScreenIntent.ExpandBottomSheet(
                            stateExpanded = stateExpanded
                        )
                    )
                },
                onSetIdle = {
                    viewModel.handleIntent(intent = SplashScreenIntent.Idle)
                }
            )
        }
        composable(MAIN_SCREEN_ROUTE) {
            MainScreen(
                currentDestination = MenuNavigationRoutes.MENU_CATEGORIES_SCREEN_ROUTE,
                appNavController = navController,
                onPopBackStack = {
                    navController.popBackStack()
                }
            )
        }
        composable(SHOPPING_CARD_ITEM_DETAILS_SCREEN_ROUTE) {
            ShoppingCartDetailsScreen()
        }
        composable(PAYMENT_CARD_INFO_SCREEN_ROUTE) {
            val viewModel: PaymentInfoViewModel = hiltViewModel()
            val state by viewModel.state.collectAsState()

            LocalLifecycleOwner.current.let { lifecycleOwner ->
                DisposableEffect(lifecycleOwner) {
                    lifecycleOwner.lifecycle.addObserver(viewModel)
                    onDispose { lifecycleOwner.lifecycle.removeObserver(viewModel) }
                }
            }

            PaymentInfoScreen(
                state = state,
                onPopBackStack = {
                    navController.popBackStack()
                },
                onSetIdle = {
                    viewModel.handleIntent(intent = PaymentInfoIntent.SetIdle)
                }
            )
        }
    }
}