package com.bloder.myanimelist.ui.home

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.bloder.myanimelist.data.topitems.model.TopItem

@Composable
fun AiringTopItem(
    modifier: Modifier,
    anime: TopItem,
    onClick: () -> Unit
) {
    HighlightAnimeItem(modifier = modifier, anime = anime, onClick = onClick) {
        Text(
            modifier = modifier,
            fontSize = 8.sp,
            text = "Score: ${anime.score}",
            maxLines = 1,
            textAlign = TextAlign.Start,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AiringTopItemPreview() {
    val anime = TopItem(
        id = null,
        rank = 2,
        title = "One Piece",
        url = "",
        image = "https://www.einerd.com.br/wp-content/uploads/2019/09/One-Piece-capa-890x466.png",
        type = "",
        episodes = 2,
        startDate = "",
        score = "10.0"
    )
    AiringTopItem(anime = anime, modifier = Modifier) {}
}