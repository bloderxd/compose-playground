package com.bloder.myanimelist.ui.home

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import com.bloder.myanimelist.data.topitems.model.TopItem

@Composable
fun UpcomingAnimeItem(
    modifier: Modifier,
    anime: TopItem,
    onClick: () -> Unit
) {
    HighlightAnimeItem(modifier = modifier, anime = anime, onClick = onClick) {
        Text(
            modifier = modifier,
            fontSize = 8.sp,
            text = "Release: ${anime.startDate}",
            maxLines = 1,
            textAlign = TextAlign.Start,
            overflow = TextOverflow.Ellipsis
        )
    }
}