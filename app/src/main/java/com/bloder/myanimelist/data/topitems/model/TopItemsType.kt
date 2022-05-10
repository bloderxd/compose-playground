package com.bloder.myanimelist.data.topitems.model

sealed class TopItemsType(val id: String) {

    object Anime : TopItemsType(id = "anime")
    object Manga : TopItemsType(id = "manga")
}