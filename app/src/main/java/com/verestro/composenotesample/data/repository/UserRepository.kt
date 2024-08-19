package com.verestro.composenotesample.data.repository

import com.verestro.composenotesample.data.model.card.CardDomainModel

interface UserRepository {

    fun getPaymentCard(): CardDomainModel
}