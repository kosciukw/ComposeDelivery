package com.verestro.composenotesample.commons.ui.components.paymentcard

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.verestro.composenotesample.R
import com.verestro.composenotesample.commons.ui.components.shapes.RoundedCard
import com.verestro.composenotesample.commons.ui.components.spacers.SpacerXXL
import com.verestro.composenotesample.commons.ui.components.spacers.SpacerXXXL
import com.verestro.composenotesample.commons.ui.dimens.BodyM
import com.verestro.composenotesample.commons.ui.dimens.BodyS
import com.verestro.composenotesample.commons.ui.dimens.BodyXL
import com.verestro.composenotesample.commons.ui.dimens.BodyXS
import com.verestro.composenotesample.commons.ui.text.dimensions.TextL
import com.verestro.composenotesample.commons.ui.text.styles.TextPaymentCard
import com.verestro.composenotesample.ui.theme.PaymentCardPlaceHolderColor
import com.verestro.composenotesample.utils.extensions.space

@Composable
fun PaymentCard(cardUiModel: CardUiModel?) {

    cardUiModel?.let { cardModel ->
        PaymentCardNonNull(cardUiModel = cardModel)
    } ?: PaymentCardPlaceHolder()
}

@Composable
private fun PaymentCardNonNull(cardUiModel: CardUiModel) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(230.dp)
            .padding(top = BodyXS, bottom = BodyXS)
            .clip(RoundedCornerShape(BodyS))
    ) {
        RoundedCard(
            containerColor = PaymentCardPlaceHolderColor,
            cornerRadius = BodyM,
            modifier = Modifier.fillMaxSize()
        ) {
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.payment_card_ellipse),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                        .graphicsLayer(translationX = 450f)
                        .clip(RoundedCornerShape(BodyM))
                )

                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(BodyXL),
                    painter = painterResource(id = R.drawable.ic_mc_logo_big),
                    alignment = Alignment.TopEnd,
                    contentDescription = null,
                    contentScale = ContentScale.Fit
                )

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(
                            start = BodyS,
                            end = BodyS,
                            top = 60.dp
                        ),
                    verticalArrangement = Arrangement.Top
                ) {
                    SpacerXXXL()

                    Text(
                        text = cardUiModel.number,
                        modifier = Modifier.fillMaxWidth(),
                        style = TextPaymentCard
                    )

                    SpacerXXL()

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(BodyS),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = cardUiModel.firstName + String.space() + cardUiModel.lastName,
                            style = TextPaymentCard.copy(fontSize = TextL)
                        )

                        Text(
                            text = cardUiModel.expiryDate,
                            style = TextPaymentCard.copy(fontSize = TextL)
                        )
                    }

                    SpacerXXXL()
                }
            }
        }
    }
}

@Composable
private fun PaymentCardPlaceHolder() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(230.dp)
            .padding(top = BodyXS, bottom = BodyXS)
            .clip(RoundedCornerShape(BodyS))
    ) {
        RoundedCard(
            containerColor = PaymentCardPlaceHolderColor,
            cornerRadius = BodyM,
            modifier = Modifier.fillMaxSize()
        ) {
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.payment_card_ellipse),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                        .graphicsLayer(translationX = 450f)
                        .clip(RoundedCornerShape(BodyM))
                )

                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(BodyXL),
                    painter = painterResource(id = R.drawable.ic_mc_logo_big),
                    alignment = Alignment.TopEnd,
                    contentDescription = null,
                    contentScale = ContentScale.Fit
                )


                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CircularProgressIndicator()
                }
            }
        }
    }
}