package com.example.movieappmad24.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieappmad24.models.Movie
import com.example.movieappmad24.data.MovieRepository

import kotlinx.coroutines.launch

class DetailViewModel(private val repository: MovieRepository,): ViewModel(),MovieViewModel {


    override fun toggleFavoriteMovie(movie: Movie){
        movie.isFavorite = !movie.isFavorite
        viewModelScope.launch {
            repository.update(movie)
        }
    }

    suspend fun findMovie(movieId:String?): Movie {
        return repository.getMovieById(movieId)
    }
}
