package com.verestro.composenotesample.data.mapper

import com.verestro.composenotesample.commons.ui.components.paymentcard.CardUiModel
import com.verestro.composenotesample.data.model.card.CardDomainModel

interface CardDomainToUiModelMapper : ModelMapper<CardDomainModel, CardUiModel>