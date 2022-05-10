package com.bloder.myanimelist.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bloder.myanimelist.core.fetch
import com.bloder.myanimelist.data.topitems.model.TopItem
import com.bloder.myanimelist.data.topitems.model.TopItemsResponse
import com.bloder.myanimelist.data.topitems.model.TopItemsSubType
import com.bloder.myanimelist.data.topitems.model.TopItemsType
import com.bloder.myanimelist.data.topitems.repository.TopItemsRepository
import com.bloder.myanimelist.data.topitems.repository.TopItemsRepositoryData
import com.bloder.myanimelist.domain.TopItemsUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel(private val topItemsUseCase: TopItemsUseCase = TopItemsUseCase(repository = TopItemsRepository)) : ViewModel() {

    private val _airingAnimes: MutableStateFlow<List<TopItem>> = MutableStateFlow(listOf())
    private val _upcomingAnimes: MutableStateFlow<List<TopItem>> = MutableStateFlow(listOf())
    val airingAnimes: StateFlow<List<TopItem>> get() = _airingAnimes
    val upcomingAnimes: StateFlow<List<TopItem>> get() = _upcomingAnimes

    fun fetchAiringAnimes() = viewModelScope.launch {
        topItemsUseCase.fetch(TopItemsRepositoryData(type = TopItemsType.Anime, subtype = TopItemsSubType.Airing)).fold({}, {
            _airingAnimes.value = it.topItems
        })
    }

    fun fetchUpcomingAnimes() = viewModelScope.launch {
        topItemsUseCase.fetch(TopItemsRepositoryData(type = TopItemsType.Anime, subtype = TopItemsSubType.Upcoming)).fold({}, {
            _upcomingAnimes.value = it.topItems
        })
    }
}