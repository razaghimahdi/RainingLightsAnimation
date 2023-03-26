package com.razaghimahdi.raininglightsanimation.ui.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class ScreenNavigation(val route: String, val arguments: List<NamedNavArgument>) {

    object Main : ScreenNavigation(
        route = "main",
        arguments = emptyList()
    )

    object Detail : ScreenNavigation(
        route = "detail",
        arguments =  listOf(navArgument("id") {
            type = NavType.IntType
        })
    )
}
