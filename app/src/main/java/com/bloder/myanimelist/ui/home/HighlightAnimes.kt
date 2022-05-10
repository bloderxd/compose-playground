package com.bloder.myanimelist.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bloder.myanimelist.data.topitems.model.TopItem
import com.google.accompanist.coil.rememberCoilPainter

@Composable
fun HighlightAnimeSection(
    modifier: Modifier,
    sectionTitle: String,
    animes: List<TopItem>,
    content: @Composable TopItem.() -> Unit
) {
    Text(
        modifier = modifier.padding(start = 15.dp),
        text = sectionTitle,
        textAlign = TextAlign.Start,
        fontSize = 18.sp
    )
    Spacer(modifier = modifier.size(5.dp))
    LazyRow(
        verticalAlignment = Alignment.CenterVertically
    ) {
        items(animes) { it.content() }
    }
}

@Composable
fun HighlightAnimeItem(
    modifier: Modifier,
    anime: TopItem,
    onClick: () -> Unit,
    animeInformation: @Composable (TopItem) -> Unit
) {
    Column(
        modifier = modifier
            .clickable(onClick = onClick)
            .size(120.dp)
            .padding(start = 10.dp, end = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = modifier.size(5.dp))
        Image(
            painter = rememberCoilPainter(request = anime.image),
            contentDescription = anime.title,
            contentScale = ContentScale.Crop,
            modifier = modifier
                .size(64.dp)
                .clip(CircleShape)
                .background(color = Color.White)
                .fillMaxSize()
                .border(1.dp, Color.Gray, CircleShape)
        )
        Spacer(modifier = modifier.size(10.dp))
        Text(
            modifier = modifier,
            fontSize = 12.sp,
            text = anime.title,
            maxLines = 1,
            textAlign = TextAlign.Center,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold
        )
        animeInformation(anime)
    }
}