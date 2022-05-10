package com.bloder.myanimelist.ui.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.bloder.myanimelist.ui.home.Home
import com.bloder.myanimelist.ui.seasonal.Seasonal

const val HOME_SECTION_ROUTE = "homeSection"
const val SEASONAL_SECTION_ROUTE = "seasonalSection"

fun NavGraphBuilder.addMainScreenGraph(modifier: Modifier) {
    composable(HOME_SECTION_ROUTE) {
        Home(modifier = modifier)
    }

    composable(SEASONAL_SECTION_ROUTE) {
        Seasonal()
    }
}