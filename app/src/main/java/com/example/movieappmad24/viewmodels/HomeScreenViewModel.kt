package com.example.movieappmad24.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieappmad24.models.Movie
import com.example.movieappmad24.models.getMovies
import com.example.movieappmad24.repositories.MovieRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeScreenViewModel(private val repository: MovieRepository,):ViewModel(),MovieViewModel {
    private val _movies = MutableStateFlow(listOf<Movie>())
    val movies: StateFlow<List<Movie>> = _movies.asStateFlow()

    init {
        viewModelScope.launch {
            getMovies().forEach { movie: Movie ->
                addMovie(movie)
            }
        }

        viewModelScope.launch {
            repository.getAllMovies().collect { movieList ->
                _movies.value = movieList
            }
        }
    }
    private suspend fun addMovie(movie: Movie){
        repository.add(movie)
    }
    override fun toggleFavoriteMovie(movie: Movie){
        movie.isFavorite = !movie.isFavorite

        viewModelScope.launch {
            repository.update(movie)
        }
    }
}
