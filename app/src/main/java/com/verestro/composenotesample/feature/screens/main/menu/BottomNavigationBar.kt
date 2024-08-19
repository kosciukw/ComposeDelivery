package com.verestro.composenotesample.feature.screens.main.menu

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.verestro.composenotesample.commons.ui.dimens.BodyEmpty

@Composable
fun BottomNavigationBar(
    currentRoute: String?,
    backgroundColor: Color,
    onItemSelected: (String) -> Unit
) {
    val items = listOf(
        MenuNavigationItem.Categories,
        MenuNavigationItem.ShoppingCart,
        MenuNavigationItem.PersonalInfo
    )

    BottomNavigation(
        backgroundColor = backgroundColor,
        elevation = BodyEmpty
    ) {
        items.forEach { item ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        painter = painterResource(id = item.iconResId),
                        contentDescription = stringResource(id = item.titleResId)
                    )
                },
                selected = currentRoute == item.route,
                onClick = { onItemSelected(item.route) }
            )
        }
    }
}