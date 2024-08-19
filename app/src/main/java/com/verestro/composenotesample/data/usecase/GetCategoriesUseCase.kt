package com.verestro.composenotesample.data.usecase

import com.verestro.composenotesample.data.model.CategoryUi
import com.verestro.composenotesample.data.repository.CategoriesRepository
import com.verestro.composenotesample.utils.usecase.UseCase
import javax.inject.Inject

class GetCategoriesUseCase
@Inject constructor(private val categoriesRepository: CategoriesRepository) :
    UseCase<List<CategoryUi>, Unit>() {

    override suspend fun action(params: Unit) = categoriesRepository.get()
}