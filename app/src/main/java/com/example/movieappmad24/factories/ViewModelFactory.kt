package com.example.movieappmad24.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.movieappmad24.data.MovieRepository
import com.example.movieappmad24.viewmodels.DetailViewModel
import com.example.movieappmad24.viewmodels.HomeScreenViewModel
import com.example.movieappmad24.viewmodels.WatchlistViewModel

class ViewModelFactory(private val repository: MovieRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(HomeScreenViewModel::class.java)){
            return HomeScreenViewModel(repository = repository) as T
        }
        if(modelClass.isAssignableFrom(DetailViewModel::class.java))
        {
            return DetailViewModel(repository = repository) as T
        }
        if(modelClass.isAssignableFrom(WatchlistViewModel::class.java))
        {
            return WatchlistViewModel(repository = repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}