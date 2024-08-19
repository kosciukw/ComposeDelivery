package com.verestro.composenotesample.utils

import com.verestro.composenotesample.R
import com.verestro.composenotesample.data.model.Category
import com.verestro.composenotesample.data.model.CategoryUi
import com.verestro.composenotesample.data.model.ShoppingProductsItemUi
import com.verestro.composenotesample.data.model.card.CardDomainModel

class Fixtures {

    fun getCategories() = listOf(
        CategoryUi(
            category = Category.VEGETABLES,
            name = "Vegetables",
            iconResourceId = R.drawable.categories_vegetables,
            subcategoriesCount = 43
        ),
        CategoryUi(
            category = Category.FRUITS,
            name = "Fruits",
            iconResourceId = R.drawable.categories_fruits,
            subcategoriesCount = 32
        ),
        CategoryUi(
            category = Category.BREAD,
            name = "Bread",
            iconResourceId = R.drawable.categories_bread,
            subcategoriesCount = 22
        ),
        CategoryUi(
            category = Category.VEGETABLES,
            name = "Vegetables",
            iconResourceId = R.drawable.categories_vegetables,
            subcategoriesCount = 43
        ),
        CategoryUi(
            category = Category.FRUITS,
            name = "Fruits",
            iconResourceId = R.drawable.categories_fruits,
            subcategoriesCount = 32
        ),
        CategoryUi(
            category = Category.BREAD,
            name = "Bread",
            iconResourceId = R.drawable.categories_bread,
            subcategoriesCount = 22
        )
    )

    fun getUserCard() = CardDomainModel(
        number = "4747   4747   4747   4747",
        firstName = "Alexandra",
        lastName = "Smith",
        expiryDate = "07/21"
    )

    companion object {
        fun getShoppingProductsItemUi() = listOf(
            ShoppingProductsItemUi(
                description = "Lorem ipsum",
                title = "Boston lettuce",
                country = "Spain",
                imageId = R.drawable.categories_vegetables,
                price = "1.10",
                currencySymbol = "$"
            ),
            ShoppingProductsItemUi(
                description = "Lorem ipsum",
                title = "Boston lettuce",
                country = "Spain",
                imageId = R.drawable.categories_vegetables,
                price = "1.10",
                currencySymbol = "$"
            ), ShoppingProductsItemUi(
                description = "Lorem ipsum",
                title = "Boston lettuce",
                country = "Spain",
                imageId = R.drawable.categories_vegetables,
                price = "1.10",
                currencySymbol = "$"
            )
        )
    }
}