package com.verestro.composenotesample.data.usecase

import com.verestro.composenotesample.data.model.CategoryUi
import com.verestro.composenotesample.data.repository.CategoriesRepository
import com.verestro.composenotesample.utils.usecase.UseCase
import javax.inject.Inject

class SearchCategoriesUseCase
@Inject constructor(private val categoriesRepository: CategoriesRepository) :
    UseCase<List<CategoryUi>, String>() {

    override suspend fun action(params: String) = categoriesRepository.filter(params)
}