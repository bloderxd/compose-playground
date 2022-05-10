package com.bloder.myanimelist.data.topitems.model

import com.squareup.moshi.Json

data class TopItemsResponse(@Json(name = "top") val topItems: List<TopItem>)

data class TopItem(
    @Json(name = "mal_id") val id: Long?,
    @Json(name = "rank") val rank: Int?,
    @Json(name = "title") val title: String,
    @Json(name = "url") val url: String?,
    @Json(name = "image_url") val image: String?,
    @Json(name = "type") val type: String?,
    @Json(name = "episodes") val episodes: Int?,
    @Json(name = "start_date") val startDate: String?,
    @Json(name = "score") val score: String?,
)