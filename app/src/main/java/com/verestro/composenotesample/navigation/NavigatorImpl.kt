package com.verestro.composenotesample.navigation

import androidx.navigation.NavController
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class NavigatorImpl @AssistedInject constructor(
    @Assisted private val navController: NavController
) : Navigator {

    @AssistedFactory
    interface Factory {
        fun create(navController: NavController): NavigatorImpl
    }

    override fun navigateTo(route: String) {
        navController.navigate(route)
    }

    override fun goBack() {
        navController.popBackStack()
    }
}