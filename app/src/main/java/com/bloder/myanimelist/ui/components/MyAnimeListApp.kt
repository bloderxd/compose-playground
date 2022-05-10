package com.bloder.myanimelist.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.bloder.myanimelist.data.MainScreenConfig
import com.bloder.myanimelist.ui.navigation.MyAnimeListNavGraph
import com.bloder.myanimelist.ui.theme.MyAnimeListTheme
import com.google.accompanist.insets.ProvideWindowInsets

@Composable
fun MyAnimeListApp() {
    ProvideWindowInsets {
        MyAnimeListTheme {
            val mainScreenSections = remember { MainScreenConfig.sections() }
            val navController = rememberNavController()
            MyAnimeListScaffold(
                bottomBar = { MyAnimeListBottomBar(backgroundColor = Color.Blue, sections = mainScreenSections) }
            ) {
                MyAnimeListNavGraph(
                    navController = navController,
                    modifier = Modifier
                )
            }
        }
    }
}