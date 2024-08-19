package com.verestro.composenotesample.feature.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.BottomSheetValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.material.rememberBottomSheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.verestro.composenotesample.R
import com.verestro.composenotesample.commons.ui.components.bottomsheet.MaterialBottomSheetScreen
import com.verestro.composenotesample.commons.ui.components.buttons.ButtonPrimary
import com.verestro.composenotesample.commons.ui.components.buttons.ButtonSecondary
import com.verestro.composenotesample.commons.ui.components.spacers.SpacerM
import com.verestro.composenotesample.commons.ui.components.spacers.SpacerXXL
import com.verestro.composenotesample.commons.ui.dimens.BodyM
import com.verestro.composenotesample.commons.ui.text.styles.TextBoldL
import com.verestro.composenotesample.commons.ui.text.styles.TextSecondary
import com.verestro.composenotesample.feature.screens.splash.state.SplashScreenState
import com.verestro.composenotesample.ui.theme.ColorCardViewBackground
import com.verestro.composenotesample.ui.theme.ColorSplashScreenBackground
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SplashScreen(
    state: SplashScreenState,
    onNavigateToMainScreen: () -> Unit,
    onExpandBottomSheet: (stateExpanded: Boolean) -> Unit,
    onSetIdle: () -> Unit
) {
    val sheetState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberBottomSheetState(BottomSheetValue.Collapsed)
    )

    LaunchedEffect(state) {
        when (state) {
            is SplashScreenState.BottomSheetExpanded -> {
                if (state.isExpanded) sheetState.bottomSheetState.expand()
                else sheetState.bottomSheetState.collapse()
                onSetIdle()
            }

            is SplashScreenState.Idle -> {
                //no-operation
            }
        }
    }

    DisposableEffect(Unit) {
        onDispose {
            onSetIdle()
        }
    }

    MaterialBottomSheetScreen(
        scaffoldState = sheetState,
        content = {
            SplashScreenBackgroundContent()
        },
        sheetContent = {
            SplashScreenBottomSheetContent(
                onDismissClicked = {
                    onExpandBottomSheet(false)
                },
                onOrderNowClicked = {
                    onNavigateToMainScreen()
                }
            )
        }
    )
}

@Composable
private fun SplashScreenBackgroundContent() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = ColorSplashScreenBackground)
    ) {
        Image(
            painter = painterResource(id = R.drawable.splash_screen_background),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(BodyM),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_logo_primary),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
private fun SplashScreenBottomSheetContent(
    onOrderNowClicked: () -> Unit,
    onDismissClicked: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(ColorCardViewBackground)
            .padding(BodyM),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SpacerXXL()
        SpacerXXL()
        Image(
            painter = painterResource(id = R.drawable.ic_logo_secondary),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        SpacerM()

        Text(
            text = stringResource(id = R.string.splash_screen_header),
            style = TextBoldL,
        )

        SpacerM()

        Text(
            text = stringResource(id = R.string.splash_screen_description),
            style = TextSecondary,
        )

        SpacerXXL()

        ButtonPrimary(
            text = stringResource(id = R.string.splash_screen_button_order_now)
        ) {
            onOrderNowClicked()
        }

        ButtonSecondary(
            text = stringResource(id = R.string.splash_screen_button_dismiss_now)
        ) {
            onDismissClicked()
        }
    }
}