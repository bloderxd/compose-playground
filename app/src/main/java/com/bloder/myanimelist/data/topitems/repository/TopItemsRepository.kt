package com.bloder.myanimelist.data.topitems.repository

import arrow.core.continuations.Effect
import arrow.core.continuations.effect
import com.bloder.myanimelist.core.Repository
import com.bloder.myanimelist.core.network.failure.Failure
import com.bloder.myanimelist.core.network.failure.NetworkFailure
import com.bloder.myanimelist.core.network.networkingWith
import com.bloder.myanimelist.data.topitems.api.TopItemsApi
import com.bloder.myanimelist.data.topitems.model.TopItemsResponse
import com.bloder.myanimelist.data.topitems.model.TopItemsSubType
import com.bloder.myanimelist.data.topitems.model.TopItemsType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

typealias TopItemsRepositoryType = Repository<TopItemsRepositoryData, Effect<Failure, TopItemsResponse>>

data class TopItemsRepositoryData(val type: TopItemsType, val subtype: TopItemsSubType)

object TopItemsRepository : TopItemsRepositoryType {

    override suspend fun TopItemsRepositoryData.load(): Effect<Failure, TopItemsResponse> = effect {
        withContext(Dispatchers.IO) {
            try {
                networkingWith(TopItemsApi::class.java).getTopItems(type = type.id, subtype = subtype.id)
            } catch (e: Exception) {
                shift(NetworkFailure(reason = "Error on request"))
            }
        }
    }
}