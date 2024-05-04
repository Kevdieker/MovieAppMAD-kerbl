package com.example.movieappmad24.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieappmad24.models.Movie
import com.example.movieappmad24.repositories.MovieRepository

import kotlinx.coroutines.launch

class DetailViewModel(private val repository: MovieRepository,): ViewModel(),MovieViewModel {
    override fun toggleFavoriteMovie(movie: Movie){
        movie.isFavorite = !movie.isFavorite

        viewModelScope.launch {
            repository.update(movie)
        }
    }

    fun findMovie(movieId:Long?): Movie?{
        var movie: Movie? = null
        viewModelScope.launch {
            movie = repository.getMovieById(movieId)
        }
        return movie
    }
}
