package com.example.movieappmad24.widget

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.movieappmad24.models.Movie
import com.example.movieappmad24.navigation.Screen
import com.example.movieappmad24.viewmodels.MovieViewModel
import kotlinx.coroutines.launch

@Composable
fun MovieList(
    modifier: Modifier,
    navController: NavController,
    viewModel: MovieViewModel,
    movies: List<Movie>,
) {
    val coroutineScope = rememberCoroutineScope()

    LazyColumn(modifier = modifier) {
        items(movies) { movie ->
            MovieCard(movie = movie,
                onFavoriteClick = {
                    coroutineScope.launch(){
                        viewModel.toggleFavoriteMovie(movie)
                    }

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