package com.verestro.composenotesample.feature.screens.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController

import androidx.navigation.compose.rememberNavController
import com.verestro.composenotesample.R
import com.verestro.composenotesample.commons.ui.dimens.BodyEmpty
import com.verestro.composenotesample.commons.ui.dimens.BodyL
import com.verestro.composenotesample.commons.ui.dimens.BodyM
import com.verestro.composenotesample.feature.screens.main.menu.BottomNavigationBar
import com.verestro.composenotesample.ui.theme.ColorBackgroundMenuScreens
import com.verestro.composenotesample.ui.theme.ColorCardViewBackground

@Composable
fun MainScreen(
    currentDestination: String,
    appNavController: NavController,
    onPopBackStack: () -> Unit
) {
    val menuNavController = rememberNavController()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    IconButton(onClick = { onPopBackStack() }) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_menu_top_bar_arrow_left),
                            contentDescription = stringResource(R.string.main_screen_top_app_bar_back_icon_description)
                        )
                    }
                },
                backgroundColor = ColorBackgroundMenuScreens,
                elevation = BodyEmpty
            )
        },
        bottomBar = {
            BottomNavigationBar(
                backgroundColor = ColorBackgroundMenuScreens,
                currentRoute = currentDestination,
                onItemSelected = { route: String ->
                    menuNavController.navigate(route) {
                        popUpTo(menuNavController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    ) { paddingValues ->
        Surface(
            modifier = Modifier.padding(paddingValues),
            color = ColorBackgroundMenuScreens
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(BodyM)
                    .background(color = ColorCardViewBackground)
            ) {
                MainNavigationNavHost(
                    menuNavController = menuNavController,
                    appNavController = appNavController
                )
            }
        }
    }
}