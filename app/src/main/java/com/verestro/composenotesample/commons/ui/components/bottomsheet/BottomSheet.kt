package com.verestro.composenotesample.commons.ui.components.bottomsheet

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.BottomSheetScaffoldState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.verestro.composenotesample.commons.ui.dimens.BodyL

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MaterialBottomSheetScreen(
    sheetContent: @Composable () -> Unit,
    content: @Composable () -> Unit,
    scaffoldState: BottomSheetScaffoldState,
    sheetGesturesEnabled: Boolean = true
) {

    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        sheetContent = { sheetContent() },
        sheetGesturesEnabled = sheetGesturesEnabled,
        sheetShape = RoundedCornerShape(
            topStart = BodyL,
            topEnd = BodyL
        ),
        content = { paddingValues ->
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                content()
            }
        }
    )
}