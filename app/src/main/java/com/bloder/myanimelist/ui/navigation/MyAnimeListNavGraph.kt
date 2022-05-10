package com.bloder.myanimelist.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.navigation

const val MAIN_SCREEN_ROUTE = "home"

@Composable
fun MyAnimeListNavGraph(
    navController: NavHostController,
    modifier: Modifier
) {
    NavHost(navController = navController, startDestination = MAIN_SCREEN_ROUTE, modifier = modifier) {
        navigation(route = MAIN_SCREEN_ROUTE, startDestination = HOME_SECTION_ROUTE) {
            addMainScreenGraph(modifier = modifier)
        }
    }
}