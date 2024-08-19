package com.verestro.composenotesample.feature.screens.main.categories.details.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.verestro.composenotesample.R
import com.verestro.composenotesample.commons.ui.components.search.SearchBar
import com.verestro.composenotesample.commons.ui.components.shapes.RoundedCard
import com.verestro.composenotesample.commons.ui.text.dimensions.TextL
import com.verestro.composenotesample.commons.ui.components.spacers.SpacerM
import com.verestro.composenotesample.commons.ui.components.spacers.SpacerS
import com.verestro.composenotesample.commons.ui.dimens.BodyM
import com.verestro.composenotesample.commons.ui.dimens.BodyXS
import com.verestro.composenotesample.commons.ui.dimens.BodyXXL
import com.verestro.composenotesample.commons.ui.dimens.BodyXXS
import com.verestro.composenotesample.commons.ui.text.styles.TextBoldL
import com.verestro.composenotesample.commons.ui.text.styles.TextPrimary
import com.verestro.composenotesample.commons.ui.text.styles.TextRegularL
import com.verestro.composenotesample.commons.ui.text.styles.TextSecondary
import com.verestro.composenotesample.data.model.Category
import com.verestro.composenotesample.data.model.ShoppingProductsItemUi
import com.verestro.composenotesample.feature.screens.main.categories.details.presentation.mvi.CategoryDetailsState
import com.verestro.composenotesample.ui.theme.ColorBackgroundMenuScreens
import com.verestro.composenotesample.ui.theme.ColorWhite
import com.verestro.composenotesample.utils.Fixtures
import com.verestro.composenotesample.utils.extensions.empty

@Composable
fun CategoryDetailsScreen(
    state: CategoryDetailsState,
    category: Category,
    onAppNavigateTo: (String) -> Unit,
    onSetIdle: () -> Unit,
    onNavigateToItemDetailsClicked: () -> Unit
) {

    LaunchedEffect(state) {
        when (state) {
            CategoryDetailsState.Idle -> Unit
            is CategoryDetailsState.Navigation -> {
                onAppNavigateTo(state.route)
                onSetIdle()
            }
        }
    }

    var searchText by remember { mutableStateOf(String.empty()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = ColorBackgroundMenuScreens)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = category.displayName,
            style = TextPrimary
        )
        SpacerM()
        SearchBar(
            hint = stringResource(id = R.string.menu_screen_search),
            text = searchText,
            onTextChange = { newText ->
                searchText = newText
            }
        )

        SpacerM()

        SubcategoryGrid(category.subcategories)

        SpacerM()

        val mockCardItems = Fixtures.getShoppingProductsItemUi()
        AvailableProductsList(mockCardItems) {
            onNavigateToItemDetailsClicked()
        }
    }
}

@Composable
private fun SubcategoryGrid(subcategories: List<Category.Subcategory>) {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxWidth()
            .height(130.dp)
            .heightIn(max = 130.dp)
    ) {
        items(subcategories) { subcategory ->
            SubcategoryItem(subcategory = subcategory)
        }
    }
}

@Composable
private fun AvailableProductsList(
    shoppingCardItems: List<ShoppingProductsItemUi>,
    onNavigateToItemDetails: () -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(max = 600.dp),
        userScrollEnabled = false
    ) {
        items(shoppingCardItems) { item ->
            CardItem(shoppingProductsItemUi = item) {
                onNavigateToItemDetails()
            }
        }
    }
}

@Composable
private fun SubcategoryItem(subcategory: Category.Subcategory) {
    Card(
        shape = RoundedCornerShape(size = BodyXXL),
        modifier = Modifier
            .padding(BodyXS)
            .width(250.dp)
            .height(50.dp),
        colors = CardDefaults.cardColors(containerColor = ColorWhite)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "${subcategory.displayName} (${subcategory.count})",
                style = TextSecondary,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
private fun CardItem(
    shoppingProductsItemUi: ShoppingProductsItemUi,
    onItemClicked: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
            .clickable {
                onItemClicked()
            }
    ) {

        RoundedCard(
            modifier = Modifier
                .size(170.dp)
                .padding(BodyXS),
            containerColor = Color.Transparent,
            cornerRadius = BodyM
        ) {
            Image(
                painter = painterResource(id = shoppingProductsItemUi.imageId),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxSize()
                .padding(BodyM),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                text = shoppingProductsItemUi.title,
                style = TextRegularL,
                textAlign = TextAlign.Center
            )

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
                    text = "" + shoppingProductsItemUi.currencySymbol + stringResource(id = R.string.card_item_piece_price_label),
                    style = TextSecondary.copy(fontSize = TextL),
                    textAlign = TextAlign.Center
                )
            }

            SpacerM()
            SpacerM()

            Row {
                Image(
                    painter = painterResource(id = R.drawable.ic_like_small),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )

                SpacerS()

                Image(
                    painter = painterResource(id = R.drawable.ic_card_add_small),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}