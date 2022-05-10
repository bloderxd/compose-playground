package com.bloder.myanimelist.ui.components

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.bloder.myanimelist.data.MainScreenSection

@Composable
fun MyAnimeListBottomBar(
    backgroundColor: Color,
    sections: List<MainScreenSection>
) {
    BottomNavigation(
        backgroundColor = backgroundColor,
        contentColor = Color.White
    ) {
        sections.map {
            BottomNavigationItem(
                icon = { Icon(painterResource(id = it.icon), contentDescription = it.name) },
                label = { Text(text = it.name) },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.White.copy(0.4f),
                alwaysShowLabel = true,
                selected = it.route == "home",
                onClick = { /*TODO*/ }
            )
        }
    }
}