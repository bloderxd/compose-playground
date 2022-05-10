package com.bloder.myanimelist.data

interface MainScreenConfig {

    fun sections(): List<MainScreenSection>

    companion object : MainScreenConfig {
        override fun sections(): List<MainScreenSection> = listOf(
            MainScreenSection.HOME,
            MainScreenSection.SEASONAL
        )
    }
}