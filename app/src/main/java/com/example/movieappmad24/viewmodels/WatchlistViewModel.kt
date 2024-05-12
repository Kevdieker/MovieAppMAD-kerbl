package com.example.movieappmad24.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieappmad24.models.Movie
import com.example.movieappmad24.data.MovieRepository
import com.example.movieappmad24.models.MovieWithImages
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class WatchlistViewModel(private val repository: MovieRepository,): ViewModel(),MovieViewModel {
    private val _favMovies = MutableStateFlow(listOf<MovieWithImages>())
    val favMovies: StateFlow<List<MovieWithImages>> = _favMovies.asStateFlow()

    init {
        viewModelScope.launch {
            repository.getFavoriteMovies().collect { movieList ->
                _favMovies.value = movieList
            }
        }
    }


     override fun toggleFavoriteMovie(movie: Movie) {
        movie.isFavorite = !movie.isFavorite
        viewModelScope.launch {
            repository.update(movie)
        }
    }

}