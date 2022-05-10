package com.bloder.myanimelist.data

import com.bloder.myanimelist.R

sealed class MainScreenSection(val name: String, val icon: Int, val route: String) {

    object HOME : MainScreenSection(name = "Home", icon = R.drawable.ic_home, route = "home")
    object SEASONAL : MainScreenSection(name = "Seasonal", icon = R.drawable.ic_seasonal, route = "seasonal")
}