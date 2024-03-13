package com.example.movieappmad24.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.movieappmad24.MovieAppScaffold
import com.example.movieappmad24.ui.theme.MovieAppMAD24Theme


@Composable
fun HomeScreen(navController: NavController) {
    MovieAppMAD24Theme {
        MovieAppScaffold(navController)
    }
}