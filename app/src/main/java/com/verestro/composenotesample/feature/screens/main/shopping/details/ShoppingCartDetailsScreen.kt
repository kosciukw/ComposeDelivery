package com.verestro.composenotesample.feature.screens.main.shopping.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomSheetValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.material.rememberBottomSheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.verestro.composenotesample.R
import com.verestro.composenotesample.commons.ui.components.bottomsheet.MaterialBottomSheetScreen
import com.verestro.composenotesample.commons.ui.components.spacers.SpacerL
import com.verestro.composenotesample.commons.ui.components.spacers.SpacerS
import com.verestro.composenotesample.commons.ui.components.spacers.SpacerXXL
import com.verestro.composenotesample.commons.ui.dimens.BodyM
import com.verestro.composenotesample.commons.ui.dimens.BodyXXS
import com.verestro.composenotesample.commons.ui.text.dimensions.TextL
import com.verestro.composenotesample.commons.ui.text.styles.TextBoldL
import com.verestro.composenotesample.commons.ui.text.styles.TextBoldM
import com.verestro.composenotesample.commons.ui.text.styles.TextBoldXL
import com.verestro.composenotesample.commons.ui.text.styles.TextSecondary
import com.verestro.composenotesample.data.model.ShoppingProductsItemUi
import com.verestro.composenotesample.ui.theme.ColorCardViewBackground

//todo Dostosowac do mvi
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ShoppingCartDetailsScreen() {

    val shoppingProductsItemUi = ShoppingProductsItemUi(
        description = "Lettuce is an annual plant of the daisy family, Asteraceae. It is most often grown as a leaf vegetable, but sometimes for its stem and seeds. Lettuce is most often used for salads, although it is also seen in other kinds of food, such as soups, sandwiches and wraps; it can also be grilled.",
        title = "Boston lettuce",
        country = "Spain",
        imageId = R.drawable.categories_vegetables,
        price = "1.10",
        currencySymbol = "$"
    )

    val sheetState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberBottomSheetState(BottomSheetValue.Expanded)
    )

    MaterialBottomSheetScreen(
        scaffoldState = sheetState,
        sheetGesturesEnabled = false,
        content = {
            Background(shoppingProductsItemUi.imageId)
        },
        sheetContent = {
            BottomSheetContent(shoppingProductsItemUi)
        }
    )
}

@Composable
private fun Background(imageId: Int) {
    Image(
        painter = painterResource(id = imageId),
        contentDescription = null,
        contentScale = ContentScale.Crop
    )
}

@Composable
private fun BottomSheetContent(shoppingProductsItemUi: ShoppingProductsItemUi) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(ColorCardViewBackground)
            .padding(BodyM),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = shoppingProductsItemUi.title,
            style = TextBoldXL
        )

        SpacerXXL()

        Row(
            horizontalArrangement = Arrangement.spacedBy(BodyXXS),
            verticalAlignment = Alignment.Top
        ) {
            Text(
                text = (shoppingProductsItemUi.price),
                style = TextBoldL,
                textAlign = TextAlign.Center
            )
            Text(
                text = shoppingProductsItemUi.currencySymbol + stringResource(id = R.string.card_item_piece_price_label),
                style = TextSecondary.copy(fontSize = TextL),
                textAlign = TextAlign.Center
            )
        }

        SpacerXXL()

        Text(
            text = shoppingProductsItemUi.country,
            style = TextBoldM
        )

        SpacerL()

        Text(
            text = shoppingProductsItemUi.description,
            style = TextSecondary.copy(textAlign = TextAlign.Start),
        )

        SpacerXXL()
        SpacerXXL()

        Row {
            Image(
                painter = painterResource(id = R.drawable.ic_like_large),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )

            SpacerS()

            Image(
                painter = painterResource(id = R.drawable.ic_add_large),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }

        SpacerXXL()
    }
}