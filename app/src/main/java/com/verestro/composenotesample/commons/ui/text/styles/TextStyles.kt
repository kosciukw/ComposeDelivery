package com.verestro.composenotesample.commons.ui.text.styles

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import com.verestro.composenotesample.commons.ui.text.dimensions.LineHeightL
import com.verestro.composenotesample.commons.ui.text.dimensions.LineHeightM
import com.verestro.composenotesample.commons.ui.text.dimensions.LineHeightS
import com.verestro.composenotesample.commons.ui.text.dimensions.LineHeightXL
import com.verestro.composenotesample.commons.ui.text.dimensions.TextL
import com.verestro.composenotesample.commons.ui.text.dimensions.TextM
import com.verestro.composenotesample.commons.ui.text.dimensions.TextS
import com.verestro.composenotesample.commons.ui.text.dimensions.TextXL
import com.verestro.composenotesample.ui.theme.ColorDarkBlue
import com.verestro.composenotesample.ui.theme.ColorLightBlue

val TextBoldXL = TextStyle(
    fontSize = LineHeightXL,
    fontWeight = FontWeight.Bold,
    color = Color.Black,
    textAlign = TextAlign.Center,
    lineHeight = LineHeightXL
)

val TextBoldL = TextStyle(
    fontSize = TextL,
    fontWeight = FontWeight.Bold,
    color = Color.Black,
    textAlign = TextAlign.Center,
    lineHeight = LineHeightL
)

val TextBoldM = TextStyle(
    fontSize = TextM,
    fontWeight = FontWeight.Bold,
    color = Color.Black,
    textAlign = TextAlign.Center,
    lineHeight = LineHeightL
)

val TextRegularS = TextStyle(
    fontSize = LineHeightS,
    color = Color.Black,
    textAlign = TextAlign.Center,
    lineHeight = LineHeightS
)

val TextRegularM = TextStyle(
    fontSize = LineHeightM,
    color = Color.Black,
    textAlign = TextAlign.Center,
    lineHeight = LineHeightM
)

val TextRegularL = TextStyle(
    fontSize = LineHeightM,
    color = Color.Black,
    textAlign = TextAlign.Center,
    lineHeight = LineHeightL
)

val TextPrimary = TextStyle(
    fontSize = LineHeightL,
    fontWeight = FontWeight.Bold,
    color = ColorDarkBlue,
    textAlign = TextAlign.Center,
    lineHeight = LineHeightL
)

val TextSecondary = TextStyle(
    fontSize = TextM,
    fontWeight = FontWeight.Light,
    color = Color.Gray,
    textAlign = TextAlign.Center,
    lineHeight = LineHeightM
)

val TextSearchBarFocused = TextStyle(
    fontSize = TextS,
    fontWeight = FontWeight.Light,
    color = Color.Gray,
    textAlign = TextAlign.Center,
    lineHeight = LineHeightM
)

val TextSearchBarUnfocused = TextStyle(
    fontSize = TextL,
    fontWeight = FontWeight.Light,
    lineHeight = LineHeightM
)

val TextCategoryPrimary = TextStyle(
    fontSize = TextL,
    fontWeight = FontWeight.Bold,
    color = Color.Black,
    textAlign = TextAlign.Center,
    lineHeight = TextL
)

val TextRegularColor = TextStyle(
    fontSize = TextM,
    fontWeight = FontWeight.Bold,
    color = ColorLightBlue,
    textAlign = TextAlign.Center,
    lineHeight = LineHeightL
)

//Payment card
val TextPaymentCard = TextStyle(
    fontFamily = FontFamily.SansSerif,
    fontWeight = FontWeight.Normal,
    fontSize = TextXL,
    color = Color.White,
    textAlign = TextAlign.Center,
    lineHeight = LineHeightM,
    fontStyle = FontStyle.Normal
)