package com.example.movieappmad24.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.movieappmad24.data.MovieDatabase
import com.example.movieappmad24.factories.ViewModelFactory
import com.example.movieappmad24.repositories.MovieRepository
import com.example.movieappmad24.viewmodels.DetailViewModel
import com.example.movieappmad24.widget.MovieCard
import com.example.movieappmad24.widget.Horizontalimageview
import com.example.movieappmad24.widget.Player
import com.example.movieappmad24.widget.SimpleTopAppBar

@Composable
fun DetailScreen(
    navController: NavController,
    movieId: Long?) {

    val db = MovieDatabase.getDatabase(LocalContext.current)
    val repository = MovieRepository(movieDao = db.movieDao())
    val factory = ViewModelFactory(repository = repository)
    val viewModel: DetailViewModel = viewModel(factory = factory)

    val movie = viewModel.findMovie(movieId = movieId)

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
                MovieCard(movie = movie,
                    onFavoriteClick = {
                        viewModel.toggleFavoriteMovie(movie)
                    })
                Player("Movie Trailer")
                Horizontalimageview(movie)
            }
        }
    }
}

