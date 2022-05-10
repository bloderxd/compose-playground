package com.bloder.myanimelist.ui.home

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun Home(modifier: Modifier, refreshHome: Boolean = false, viewModel: HomeViewModel = viewModel()) {
    val topAiringAnimes by viewModel.airingAnimes.collectAsState()
    val topUpcomingAnimes by viewModel.upcomingAnimes.collectAsState()
    LaunchedEffect(refreshHome) {
        viewModel.fetchAiringAnimes()
        viewModel.fetchUpcomingAnimes()
    }
    LazyColumn {
        item {
            HighlightAnimeSection(modifier = modifier, sectionTitle = "Airing Animes", animes = topAiringAnimes) {
                AiringTopItem(modifier = modifier, anime = this) {}
            }
            Spacer(modifier = modifier.size(5.dp))
            HighlightAnimeSection(modifier = modifier, sectionTitle = "Upcoming Animes", animes = topUpcomingAnimes) {
                UpcomingAnimeItem(modifier = modifier, anime = this) {}
            }
        }
    }
}