package com.verestro.composenotesample.feature.screens.main.categories.preview.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.verestro.composenotesample.commons.ui.components.shapes.RoundedCard
import com.verestro.composenotesample.commons.ui.dimens.BodyM
import com.verestro.composenotesample.commons.ui.dimens.BodyS
import com.verestro.composenotesample.commons.ui.text.styles.TextCategoryPrimary
import com.verestro.composenotesample.commons.ui.text.styles.TextSecondary
import com.verestro.composenotesample.data.model.Category
import com.verestro.composenotesample.data.model.CategoryUi

@Composable
fun CategoryCard(
    modifier: Modifier = Modifier,
    categoryUi: CategoryUi,
    onClickListener: (Category) -> Unit
) {
    RoundedCard(
        modifier = modifier
            .width(100.dp)
            .padding(BodyS)
            .clickable {
                onClickListener(categoryUi.category)
            },
        containerColor = Color.White,
        cornerRadius = BodyM
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxSize()
        ) {

            Image(
                painter = painterResource(id = categoryUi.iconResourceId),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Column(
                modifier = modifier.padding(BodyS)
            ) {
                Spacer(modifier = Modifier.height(BodyS))

                Text(
                    text = categoryUi.name,
                    textAlign = TextAlign.Start,
                    style = TextCategoryPrimary
                )

                Spacer(modifier = Modifier.height(BodyS))

                Text(
                    text = categoryUi.subcategoriesCount.toString(),
                    textAlign = TextAlign.Start,
                    style = TextSecondary
                )
            }
        }
        Spacer(modifier = Modifier.height(BodyS))
    }
}