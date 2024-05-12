package com.example.movieappmad24.screens


import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.movieappmad24.data.MovieDatabase
import com.example.movieappmad24.factories.ViewModelFactory
import com.example.movieappmad24.data.MovieRepository
import com.example.movieappmad24.viewmodels.HomeScreenViewModel
import com.example.movieappmad24.widget.MovieList
import com.example.movieappmad24.widget.SimpleBottomAppBar
import com.example.movieappmad24.widget.SimpleTopAppBar

@Composable
fun HomeScreen(
    navController: NavController
){

 val db = MovieDatabase.getDatabase(LocalContext.current)
 val repository = MovieRepository(movieDao = db.movieDao())
 val factory = ViewModelFactory(repository = repository)
 val viewModel: HomeScreenViewModel = viewModel(factory = factory)
    val moviesState by viewModel.movies.collectAsState()

    Scaffold(
        topBar = {
            SimpleTopAppBar(
                title = "Movie App",
                onNavigationIconClick = null
            )
        },
        bottomBar = { SimpleBottomAppBar(navController) }
    ) { innerPadding ->
        MovieList(
            modifier = Modifier.padding(innerPadding),
            navController = navController,
            movies = moviesState,
            viewModel = viewModel
        )
    }
}
