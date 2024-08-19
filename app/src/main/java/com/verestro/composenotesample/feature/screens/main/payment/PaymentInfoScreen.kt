package com.verestro.composenotesample.feature.screens.main.payment

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.verestro.composenotesample.R
import com.verestro.composenotesample.commons.ui.components.buttons.ButtonPrimary
import com.verestro.composenotesample.commons.ui.components.paymentcard.CardUiModel
import com.verestro.composenotesample.commons.ui.components.paymentcard.PaymentCard
import com.verestro.composenotesample.commons.ui.components.spacers.SpacerL
import com.verestro.composenotesample.commons.ui.components.spacers.SpacerM
import com.verestro.composenotesample.commons.ui.components.spacers.SpacerS
import com.verestro.composenotesample.commons.ui.dimens.BodyEmpty
import com.verestro.composenotesample.commons.ui.dimens.BodyM
import com.verestro.composenotesample.commons.ui.dimens.BodyXS
import com.verestro.composenotesample.commons.ui.text.dimensions.TextM
import com.verestro.composenotesample.commons.ui.text.styles.TextPrimary
import com.verestro.composenotesample.commons.ui.text.styles.TextSecondary
import com.verestro.composenotesample.feature.screens.main.payment.mvi.PaymentInfoState
import com.verestro.composenotesample.ui.theme.ColorBackgroundMenuScreens
import com.verestro.composenotesample.ui.theme.ColorTransparent
import com.verestro.composenotesample.ui.theme.ColorWhite
import com.verestro.composenotesample.utils.extensions.empty

@Composable
fun PaymentInfoScreen(
    state: PaymentInfoState,
    onPopBackStack: () -> Unit,
    onSetIdle: () -> Unit
) {

    var paymentCard by remember { mutableStateOf<CardUiModel?>(null) }
    var cardNameInputText by remember { mutableStateOf(String.empty()) }
    var cardNumberInputText by remember { mutableStateOf(String.empty()) }
    var cardExpiryInputText by remember { mutableStateOf(String.empty()) }
    var cardCvcInputText by remember { mutableStateOf(String.empty()) }

    LaunchedEffect(state) {
        when (state) {
            PaymentInfoState.Idle -> Unit

            is PaymentInfoState.DisplayCard -> {
                paymentCard = state.card
                onSetIdle()
            }
        }
    }

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
        }
    ) { paddingValues ->
        Surface(
            modifier = Modifier.padding(paddingValues),
            color = ColorBackgroundMenuScreens
        ) {
            Column(
                modifier = Modifier
                    .padding(BodyM)
                    .verticalScroll(rememberScrollState())
            ) {
                Text(
                    text = stringResource(id = R.string.payment_info_screen_header),
                    textAlign = TextAlign.Start,
                    style = TextPrimary
                )

                SpacerM()

                PaymentCard(cardUiModel = paymentCard)

                SpacerL()

                Image(
                    modifier = Modifier.fillMaxWidth(),
                    alignment = Alignment.Center,
                    painter = painterResource(id = R.drawable.ic_camera),
                    contentDescription = null
                )

                SpacerL()

                InputField(
                    header = "Name on card",
                    inputFieldText = cardNameInputText,
                    modifier = Modifier.fillMaxWidth(),
                    onTextChange = {
                        cardNameInputText = it
                    }
                )

                SpacerL()

                InputField(
                    inputFieldText = cardNumberInputText,
                    iconId = R.drawable.ic_mc_logo_small,
                    header = "Card number",
                    modifier = Modifier.fillMaxWidth(),
                    onTextChange = {
                        cardNumberInputText = it
                    }
                )

                SpacerL()

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    InputField(
                        inputFieldText = cardExpiryInputText,
                        header = "Expiry date",
                        modifier = Modifier.weight(1f),
                        onTextChange = {
                            cardExpiryInputText = it
                        }
                    )
                    SpacerS()
                    InputField(
                        inputFieldText = cardCvcInputText,
                        header = "CVC",
                        modifier = Modifier.weight(1f),
                        onTextChange = {
                            cardCvcInputText = it
                        }
                    )
                }

                SpacerL()

                ButtonPrimary(
                    text = stringResource(id = R.string.payment_info_screen_button)
                ) {
//            onOrderNowClicked()
                }

            }
        }
    }
}

@Composable
private fun InputField(
    modifier: Modifier = Modifier,
    inputFieldText: String,
    header: String,
    iconId: Int? = null,
    onTextChange: (String) -> Unit
) {
    Column(modifier = modifier) {
        Text(
            modifier = Modifier.padding(BodyXS),
            text = header,
            style = TextSecondary.copy(fontSize = TextM),
            textAlign = TextAlign.Center
        )
        Card(
            modifier = Modifier
                .height(50.dp)
                .border(
                    1.dp,
                    Color.LightGray,
                    shape = RoundedCornerShape(BodyXS)
                )
                .background(color = ColorTransparent),
            shape = RoundedCornerShape(BodyXS),
        ) {
            InputField(
                modifier = modifier
                    .fillMaxSize()
                    .background(color = ColorTransparent),
                iconId = iconId,
                text = inputFieldText,
                onTextChange = { inputText ->
                    onTextChange(inputText)
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun InputField(
    modifier: Modifier = Modifier,
    text: String,
    iconId: Int?,
    maxLine: Int = 1,
    onTextChange: (String) -> Unit,
    onImeAction: () -> Unit = {}
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    val isFocused = remember {
        mutableStateOf(false)
    }

    TextField(
        modifier = modifier
            .background(color = ColorWhite)
            .onFocusChanged { focusState ->
                isFocused.value = focusState.isFocused
            },
        value = text,
        onValueChange = {
            onTextChange(it)
        },
        colors = TextFieldDefaults.textFieldColors(
            containerColor = ColorTransparent,
            focusedIndicatorColor = ColorTransparent,
            unfocusedIndicatorColor = ColorTransparent
        ),
        maxLines = maxLine,
        trailingIcon = {
            iconId?.let {
                Image(
                    painter = painterResource(id = it),
                    contentDescription = null,
                    contentScale = ContentScale.Fit
                )
            }
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                onImeAction()
                keyboardController?.hide()
            }
        )
    )
}