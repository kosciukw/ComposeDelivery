package com.verestro.composenotesample.data.mapper.impl

import com.verestro.composenotesample.commons.ui.components.paymentcard.CardUiModel
import com.verestro.composenotesample.data.mapper.CardDomainToUiModelMapper
import com.verestro.composenotesample.data.model.card.CardDomainModel

class CardDomainToUiModelMapperImpl : CardDomainToUiModelMapper {

    override fun map(input: CardDomainModel) = with(input) {
        CardUiModel(
            number = number,
            firstName = firstName,
            lastName = lastName,
            expiryDate = expiryDate
        )
    }
}