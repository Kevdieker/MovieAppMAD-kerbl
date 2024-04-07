package com.example.movieappmad24.screens


import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.movieappmad24.ui.theme.MovieAppMAD24Theme
import com.example.movieappmad24.viewmodels.MoviesViewModel
import com.example.movieappmad24.widget.MovieList
import com.example.movieappmad24.widget.SimpleBottomAppBar
import com.example.movieappmad24.widget.SimpleTopAppBar

@Composable
fun WatchlistScreen(navController: NavController,moviesViewModel: MoviesViewModel) {
    MovieAppMAD24Theme {
        Scaffold(
            topBar = { SimpleTopAppBar(title = "Movie App",
                onNavigationIconClick = null
            ) },
            bottomBar = { SimpleBottomAppBar(navController) }
        ) { innerPadding ->    MovieList(navController = navController,moviesViewModel.favoriteMovies, padding =innerPadding) }
    }
}