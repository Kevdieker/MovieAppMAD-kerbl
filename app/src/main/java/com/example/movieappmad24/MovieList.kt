package com.example.movieappmad24

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

@Composable
fun MovieList(navController: NavController, list: List<Movie> = getMovies(), padding: PaddingValues) {
    LazyColumn (modifier = Modifier.padding(padding)){
        items(list) { movie ->
            MovieCard(movie = movie){movieId ->
                navController.navigate(route = Screen.Detail.route.replace("{movieId}", movieId))
            }
        }
    }
}