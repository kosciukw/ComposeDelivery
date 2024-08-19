package com.verestro.composenotesample.navigation

interface Navigator {
    fun navigateTo(route: String)
    fun goBack()
}