package com.verestro.composenotesample.feature.screens.main.payment

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.viewModelScope
import com.verestro.composenotesample.commons.base.BaseViewModel
import com.verestro.composenotesample.data.mapper.CardDomainToUiModelMapper
import com.verestro.composenotesample.data.usecase.GetPaymentCardUseCase
import com.verestro.composenotesample.feature.screens.main.payment.mvi.PaymentInfoIntent
import com.verestro.composenotesample.feature.screens.main.payment.mvi.PaymentInfoState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class PaymentInfoViewModel @Inject constructor(
    private val getPaymentCardUseCase: GetPaymentCardUseCase,
    private val cardDomainToUiModelMapper: CardDomainToUiModelMapper
) : BaseViewModel() {

    private val _state = MutableStateFlow<PaymentInfoState>(PaymentInfoState.Idle)
    val state: StateFlow<PaymentInfoState> = _state

    override fun onResume(owner: LifecycleOwner) {
        handleIntent(intent = PaymentInfoIntent.GetUserPaymentCard)
    }

    fun handleIntent(intent: PaymentInfoIntent) {
        when (intent) {
            is PaymentInfoIntent.SetIdle -> setIdle()
            is PaymentInfoIntent.GetUserPaymentCard -> getPaymentCard()
        }
    }

    private fun setIdle() {
        _state.value = PaymentInfoState.Idle
    }

    private fun getPaymentCard() {
        getPaymentCardUseCase(
            params = Unit,
            viewModelScope = viewModelScope
        ) { result ->
            result.onSuccess { card ->
                card?.let {
                    val cardUiModel = cardDomainToUiModelMapper.map(input = card)
                    _state.value = PaymentInfoState.DisplayCard(
                        card = cardUiModel,
                        isLoading = false
                    )
                }
            }
            result.onFailure { error -> error.printStackTrace() }
        }
    }
}