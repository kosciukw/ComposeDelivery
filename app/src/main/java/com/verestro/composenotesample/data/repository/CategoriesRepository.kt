package com.verestro.composenotesample.data.repository

import com.verestro.composenotesample.data.model.CategoryUi

interface CategoriesRepository {
    suspend fun get(): List<CategoryUi>
    suspend fun filter(predicate: String): List<CategoryUi>
}