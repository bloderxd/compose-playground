package com.bloder.myanimelist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.bloder.myanimelist.data.MainScreenConfig
import com.bloder.myanimelist.ui.components.MyAnimeListApp
import com.bloder.myanimelist.ui.components.MyAnimeListBottomBar
import com.bloder.myanimelist.ui.components.MyAnimeListScaffold
import com.bloder.myanimelist.ui.navigation.MyAnimeListNavGraph
import com.bloder.myanimelist.ui.theme.MyAnimeListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAnimeListApp()
        }
    }
}