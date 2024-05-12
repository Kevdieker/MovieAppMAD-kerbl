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

class DetailViewModel(private val repository: MovieRepository,): ViewModel(),MovieViewModel {


     override fun toggleFavoriteMovie(movie: Movie){
        movie.isFavorite = !movie.isFavorite
        viewModelScope.launch {
            repository.update(movie)
        }
    }
    private var _movie = MutableStateFlow<MovieWithImages?>(null)
    fun findMovie(movieId:String?): StateFlow<MovieWithImages?> {
        viewModelScope.launch {
            repository.getMovieById(movieId)?.collect {
                _movie.value = it
            }
        }
        return _movie.asStateFlow()
    }
}
