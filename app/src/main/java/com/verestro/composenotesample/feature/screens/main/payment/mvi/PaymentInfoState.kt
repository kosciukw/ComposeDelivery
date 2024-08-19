package com.verestro.composenotesample.feature.screens.main.payment.mvi

import com.verestro.composenotesample.commons.ui.components.paymentcard.CardUiModel

sealed class PaymentInfoState {

    object Idle : PaymentInfoState()

    data class DisplayCard(
        val card: CardUiModel,
        val isLoading: Boolean
    ) : PaymentInfoState()
}