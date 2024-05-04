package com.example.movieappmad24.viewmodels

import com.example.movieappmad24.models.Movie

interface MovieViewModel {
    fun toggleFavoriteMovie(movie: Movie)
}