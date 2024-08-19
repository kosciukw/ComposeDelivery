package com.verestro.composenotesample.data.model

import com.verestro.composenotesample.utils.extensions.empty

data class CategoryUi(
    val category: Category,
    val name: String,
    val iconResourceId: Int,
    val subcategoriesCount: Int
) {

    override fun toString() = String.empty()
}