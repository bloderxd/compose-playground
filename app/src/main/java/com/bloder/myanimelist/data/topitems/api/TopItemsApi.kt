package com.bloder.myanimelist.data.topitems.api

import com.bloder.myanimelist.data.topitems.model.TopItemsResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface TopItemsApi {

    @GET("top/{type}/1/{subtype}")
    suspend fun getTopItems(@Path("type") type: String, @Path("subtype") subtype: String): TopItemsResponse
}