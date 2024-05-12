package com.example.movieappmad24.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieappmad24.models.Movie
import com.example.movieappmad24.models.getMovies
import com.example.movieappmad24.data.MovieRepository
import com.example.movieappmad24.models.MovieImage
import com.example.movieappmad24.models.MovieWithImages
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch

class HomeScreenViewModel(private val repository: MovieRepository,):ViewModel(),MovieViewModel {
    private val _movies = MutableStateFlow(listOf<MovieWithImages>())
    val movies: StateFlow<List<MovieWithImages>> = _movies.asStateFlow()

    init {
        viewModelScope.launch {
            val movies = getMovies()
            movies.forEachIndexed { index, movie ->
                val existingMovie = repository.getMovieById(movie.movieId)?.firstOrNull()
                if (existingMovie == null) {
                    val movieIndex = index + 1
                    addMovie(movie)
                    movie.images.forEach { imageUrl ->
                        repository.addImage(
                            MovieImage(
                                movie2Id = movieIndex.toLong(),
                                url = imageUrl
                            )
                        )
                    }
                } else {
                    // Movie exists, ensure all its images are loaded (if not already)
                    ensureImagesAreLoaded(existingMovie, movie.images)
                }

            }
            repository.getAllMovies().collect { movieList ->
                _movies.value = movieList
            }
        }
    }
    private suspend fun ensureImagesAreLoaded(movieWithImages: MovieWithImages, images: List<String>) {
        val existingImages = movieWithImages.movie.images
        images.filterNot { it in existingImages }.forEach { imageUrl ->
            repository.addImage(MovieImage(movie2Id = movieWithImages.movie.id, url = imageUrl))
        }
    }

    private suspend fun addMovie(movie: Movie) {
            repository.add(movie)
    }
     override fun toggleFavoriteMovie(movie: Movie){
        movie.isFavorite = !movie.isFavorite

        viewModelScope.launch {
            repository.update(movie)
        }
    }
}
