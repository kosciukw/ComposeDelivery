package com.verestro.composenotesample.commons.ui.components.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.verestro.composenotesample.R
import com.verestro.composenotesample.commons.ui.components.input.InputText
import com.verestro.composenotesample.commons.ui.dimens.BodyS
import com.verestro.composenotesample.commons.ui.dimens.BodyXXXL
import com.verestro.composenotesample.ui.theme.ColorTransparent

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    text: String,
    hint: String,
    onTextChange: (String) -> Unit,
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(BodyS)
            .background(color = ColorTransparent),
        shape = RoundedCornerShape(BodyXXXL),
    ) {
        InputText(
            modifier = modifier
                .fillMaxWidth()
                .background(color = ColorTransparent),
            text = text,
            label = hint,
            iconId = R.drawable.ic_search,
            onTextChange = { searchPredicate ->
                onTextChange(searchPredicate)
            }
        )
    }
}