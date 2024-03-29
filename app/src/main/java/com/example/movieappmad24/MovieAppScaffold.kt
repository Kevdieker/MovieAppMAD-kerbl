package com.example.movieappmad24

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.movieappmad24.models.getMovies


@Composable
fun MovieAppScaffold(navController: NavController) {
    Scaffold(
        topBar = { MovieAppTopBar() },
        bottomBar = { MovieAppBotBar() }
    ) { innerPadding -> MovieList(navController = navController,list=getMovies(), padding=innerPadding) }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieAppTopBar() {
    CenterAlignedTopAppBar(
        title = { Text(text = "Movie App") },
    )
}

@Composable
fun MovieAppBotBar() {
    NavigationBar() {
        NavigationBarItem(
            icon = {
                Icon(Icons.Outlined.Home, contentDescription = "Home")
            },
            label = { Text("Home") },
            selected = false,
            onClick = { }
        )

        NavigationBarItem(
            icon = {
                Icon(Icons.Outlined.Star, contentDescription = "Favorites")
            },
            label = { Text("Favorites") },
            selected = false,
            onClick = { }
        )
    }
}