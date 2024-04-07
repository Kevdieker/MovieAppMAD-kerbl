package com.example.movieappmad24.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp

import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.movieappmad24.widget.MovieCard
import com.example.movieappmad24.models.getMovies
import com.example.movieappmad24.viewmodels.MoviesViewModel
import com.example.movieappmad24.widget.SimpleTopAppBar

@Composable
fun DetailScreen(navController: NavController, movieId: String?,moviesViewModel: MoviesViewModel) {
    val movie = getMovies().find { it.id == movieId }
    Scaffold(
        topBar = {
            SimpleTopAppBar(
                title = movie?.title ?: "Movie Not Found",
                onNavigationIconClick = { navController.popBackStack() }
            )
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            movie?.let { safeMovie ->
                MovieCard(movie = safeMovie)
                LazyRow(modifier = Modifier.padding(8.dp)) {
                    items(safeMovie.images.drop(1)) { image ->
                        Card(modifier = Modifier.padding(end = 8.dp)) {
                            AsyncImage(
                                model = image,
                                modifier = Modifier.size(128.dp),
                                contentScale = ContentScale.Crop,
                                contentDescription = "Movie Image"
                            )
                        }
                    }
                }
            }
        }
    }
}

