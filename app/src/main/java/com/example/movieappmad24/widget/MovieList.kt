package com.example.movieappmad24.widget

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.movieappmad24.models.Movie
import com.example.movieappmad24.navigation.Screen
import com.example.movieappmad24.viewmodels.MovieViewModel

@Composable
fun MovieList(
    modifier: Modifier,
    navController: NavController,
    viewModel: MovieViewModel,
    movies: List<Movie>,
) {

    LazyColumn(modifier = modifier) {
        items(movies) { movie ->
            MovieCard(movie = movie,
                onFavoriteClick = {
                    viewModel.toggleFavoriteMovie(movie)
                },
                onItemClick = { movieId ->
                    navController.navigate(
                        route = Screen.Detail.route.replace(
                            "{movieId}",
                            movieId.toString()
                        )
                    )
                })
        }
    }
}