package com.verestro.composenotesample.data.usecase

import com.verestro.composenotesample.data.model.card.CardDomainModel
import com.verestro.composenotesample.data.repository.UserRepository
import com.verestro.composenotesample.utils.usecase.UseCase
import javax.inject.Inject

class GetPaymentCardUseCase
@Inject constructor(private val userRepository: UserRepository) :
    UseCase<CardDomainModel, Unit>() {

    override suspend fun action(params: Unit) = userRepository.getPaymentCard()
}