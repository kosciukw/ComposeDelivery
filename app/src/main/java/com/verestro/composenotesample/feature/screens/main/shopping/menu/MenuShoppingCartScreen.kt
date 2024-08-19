package com.verestro.composenotesample.feature.screens.main.shopping.menu

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.verestro.composenotesample.R
import com.verestro.composenotesample.commons.ui.components.spacers.SpacerL
import com.verestro.composenotesample.commons.ui.components.spacers.SpacerXL
import com.verestro.composenotesample.commons.ui.dimens.BodyS
import com.verestro.composenotesample.commons.ui.text.styles.TextBoldM
import com.verestro.composenotesample.commons.ui.text.styles.TextRegularColor
import com.verestro.composenotesample.commons.ui.text.styles.TextSecondary
import com.verestro.composenotesample.feature.screens.main.shopping.menu.mvi.MenuShoppingCartState
import com.verestro.composenotesample.ui.theme.ColorCardViewBackground

@Composable
fun MenuShoppingCartScreen(
    state: MenuShoppingCartState,
    onNavigateToPaymentInfoClicked: () -> Unit,
    onSetIdle: () -> Unit
) {
    var isChecked by remember { mutableStateOf(false) }

    LaunchedEffect(state) {
        when (state) {
            MenuShoppingCartState.Idle -> Unit
            else -> onSetIdle()
        }
    }

    Column(
        modifier = Modifier
            .background(
                color = ColorCardViewBackground
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(BodyS),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                style = TextBoldM,
                text = stringResource(id = R.string.menu_shopping_cart_screen_payment_method)
            )

            Text(
                modifier = Modifier.clickable {
                    onNavigateToPaymentInfoClicked()
                },
                style = TextRegularColor,
                text = stringResource(id = R.string.menu_shopping_cart_screen_change)
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(BodyS),
            horizontalArrangement = Arrangement.Absolute.Left
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_credit_card),
                contentDescription = null
            )

            SpacerL()

            Text(
                style = TextSecondary,
                text = stringResource(id = R.string.menu_shopping_cart_screen_credit_card_number_fixture)
            )
        }

        SpacerXL()

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(BodyS),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                style = TextBoldM,
                text = stringResource(id = R.string.menu_shopping_cart_screen_delivery_address)
            )

            Text(
                style = TextRegularColor,
                text = stringResource(id = R.string.menu_shopping_cart_screen_change)
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(BodyS),
            horizontalArrangement = Arrangement.Absolute.Left
        ) {

            Image(
                painter = painterResource(id = R.drawable.ic_home),
                contentDescription = null
            )

            SpacerL()

            Text(
                style = TextSecondary.copy(
                    textAlign = TextAlign.Left
                ),
                text = stringResource(id = R.string.menu_shopping_cart_screen_credit_address_fixture)
            )
        }

        SpacerXL()

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(BodyS),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                style = TextBoldM,
                text = stringResource(id = R.string.menu_shopping_cart_screen_delivery_options)
            )

            Text(
                style = TextRegularColor,
                text = stringResource(id = R.string.menu_shopping_cart_screen_change)
            )
        }

        //todo: below should be a spinner

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(BodyS),
            horizontalArrangement = Arrangement.Absolute.Left
        ) {

            Image(
                painter = painterResource(id = R.drawable.ic_human_walking),
                contentDescription = null
            )

            SpacerL()

            Text(
                style = TextSecondary,
                text = stringResource(id = R.string.menu_shopping_cart_screen_delivery_option_self)
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(BodyS),
            horizontalArrangement = Arrangement.Absolute.Left
        ) {

            Image(
                painter = painterResource(id = R.drawable.ic_human_riding_bike),
                contentDescription = null
            )

            SpacerL()

            Text(
                style = TextSecondary,
                text = stringResource(id = R.string.menu_shopping_cart_screen_delivery_option_courier)
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(BodyS),
            horizontalArrangement = Arrangement.Absolute.SpaceBetween
        ) {
            Row(
                modifier = Modifier,
                horizontalArrangement = Arrangement.Absolute.Left
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_drone),
                    contentDescription = null
                )

                SpacerL()

                Text(
                    style = TextSecondary,
                    text = stringResource(id = R.string.menu_shopping_cart_screen_delivery_option_drone)
                )
            }

            Image(
                painter = painterResource(id = R.drawable.ic_check),
                contentDescription = null
            )
        }


        SpacerXL()

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(BodyS),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                style = TextBoldM,
                text = stringResource(id = R.string.menu_shopping_cart_screen_non_contact_delivery)
            )

            Switch(
                checked = isChecked,
                onCheckedChange = { newValue -> isChecked = newValue }
            )
        }
    }
}