package com.example.movieappmad24.navigation

sealed class Screen (val route: String){
    data object Home: Screen(route = "home-screen")
    data object Detail: Screen(route = "detail-screen/{movieId}")
}