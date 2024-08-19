package com.verestro.composenotesample.data.repository.impl

import com.verestro.composenotesample.data.repository.CategoriesRepository
import com.verestro.composenotesample.utils.Fixtures
import javax.inject.Inject

class CategoryRepositoryImpl
@Inject constructor(private val fixtures: Fixtures) : CategoriesRepository {

    override suspend fun get() = fixtures.getCategories()
    override suspend fun filter(predicate: String) = fixtures.getCategories().filter {
        it.name.lowercase().contains(predicate.lowercase())
    }
}