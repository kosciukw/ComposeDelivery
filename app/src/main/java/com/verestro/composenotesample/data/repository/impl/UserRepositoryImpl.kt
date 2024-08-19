package com.verestro.composenotesample.data.repository.impl

import com.verestro.composenotesample.data.repository.UserRepository
import com.verestro.composenotesample.utils.Fixtures

class UserRepositoryImpl(
   private val fixtures: Fixtures
) : UserRepository {
    override fun getPaymentCard() = fixtures.getUserCard()
}