package com.verestro.composenotesample.feature.screens.main.menu

import com.verestro.composenotesample.R


sealed class MenuNavigationItem(val titleResId: Int, val iconResId: Int, val route: String) {
    object Categories : MenuNavigationItem(
        titleResId = R.string.bottom_menu_categories_title,
        iconResId = R.drawable.ic_menu_categories_empty,
        route = MenuNavigationRoutes.MENU_CATEGORIES_SCREEN_ROUTE,

    )

    object ShoppingCart : MenuNavigationItem(
        titleResId = R.string.bottom_menu_shopping_cart_title,
        iconResId = R.drawable.ic_menu_shopping_cart_empty,
        route = MenuNavigationRoutes.MENU_SHOPPING_CART_SCREEN_ROUTE
    )

    object PersonalInfo : MenuNavigationItem(
        titleResId = R.string.bottom_menu_personal_info_title,
        iconResId = R.drawable.ic_menu_user_empty,
        route = MenuNavigationRoutes.MENU_SHOPPING_CART_SCREEN_ROUTE
    )
}
