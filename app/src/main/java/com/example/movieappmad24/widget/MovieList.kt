package com.example.movieappmad24.widget

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.movieappmad24.models.Movie
import com.example.movieappmad24.models.getMovies
import com.example.movieappmad24.navigation.Screen
import com.example.movieappmad24.viewmodels.MoviesViewModel

@Composable
fun MovieList(
    modifier: Modifier,
    navController: NavController,
    viewModel: MoviesViewModel,
    movies: List<Movie> = getMovies(),
) {
    LazyColumn(modifier = modifier) {
        items(movies) { movie ->
            MovieCard(movie = movie,
                onFavoriteClick = {
                    viewModel.toggleFavoriteMovie(movie.id)
                },
                onItemClick = { movieId ->
                    navController.navigate(
                        route = Screen.Detail.route.replace(
                            "{movieId}",
                            movieId
                        )
                    )
                })
        }
    }
}