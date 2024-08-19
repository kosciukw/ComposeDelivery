package com.verestro.composenotesample.data.model.subcategories

import com.verestro.composenotesample.data.model.Category

enum class VegetablesSubcategory(
    override val displayName: String,
    override val count: Int
) : Category.Subcategory {
    CABBAGE_AND_LETTUCE("Cabbage and lettuce", 5),
    CUCUMBERS_AND_TOMATO("Cucumbers and tomato", 15),
    ONIONS_AND_GARLIC("Onions and garlic", 20),
    PEPPERS("Peppers", 16),
    POTATOES_AND_CARROTS("Potatoes and carrots", 13)
}