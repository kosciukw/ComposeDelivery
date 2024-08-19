package com.verestro.composenotesample.feature.screens.main.payment.mvi

sealed class PaymentInfoIntent {
    object SetIdle : PaymentInfoIntent()
    object GetUserPaymentCard: PaymentInfoIntent()
}