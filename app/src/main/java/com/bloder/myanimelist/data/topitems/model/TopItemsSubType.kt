package com.bloder.myanimelist.data.topitems.model

sealed class TopItemsSubType(val id: String) {

    object Airing : TopItemsSubType(id = "airing")
    object Upcoming : TopItemsSubType(id = "upcoming")
}