package com.example.movieappmad24.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.movieappmad24.widget.MovieCard
import com.example.movieappmad24.viewmodels.MoviesViewModel
import com.example.movieappmad24.widget.Horizontalimageview
import com.example.movieappmad24.widget.Player
import com.example.movieappmad24.widget.SimpleTopAppBar

@Composable
fun DetailScreen(
    navController: NavController,
    movieId: String?,
    moviesViewModel: MoviesViewModel) {

    val movie = moviesViewModel.movies.find { it.id == movieId }

    Scaffold(
        topBar = {
            SimpleTopAppBar(
                title = movie?.title ?: "Movie Not Found",
                onNavigationIconClick = { navController.popBackStack() }
            )
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            movie?.let { movie ->
                MovieCard(movie)
                Player("Movie Trailer")
                Horizontalimageview(movie)
            }
        }
    }
}

