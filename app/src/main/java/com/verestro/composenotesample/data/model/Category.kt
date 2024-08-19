package com.verestro.composenotesample.data.model

import com.verestro.composenotesample.data.model.subcategories.VegetablesSubcategory


enum class Category(
    val displayName: String,
    val subcategories: List<Subcategory>
) {
    VEGETABLES(
        displayName = "Vegetables",
        subcategories = listOf(
            VegetablesSubcategory.CABBAGE_AND_LETTUCE,
            VegetablesSubcategory.CUCUMBERS_AND_TOMATO,
            VegetablesSubcategory.ONIONS_AND_GARLIC,
            VegetablesSubcategory.PEPPERS,
            VegetablesSubcategory.POTATOES_AND_CARROTS
        )
    ),
    FRUITS(
        displayName = "Vegetables",
        subcategories = emptyList()
    ),
    BREAD(
        displayName = "Vegetables",
        subcategories = emptyList()
    );

    interface Subcategory {
        val displayName: String
        val count: Int
    }
}