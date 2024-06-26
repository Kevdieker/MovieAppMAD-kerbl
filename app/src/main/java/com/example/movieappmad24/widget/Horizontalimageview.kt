package com.example.movieappmad24.widget

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.movieappmad24.models.Movie
import com.example.movieappmad24.models.MovieWithImages

@Composable fun Horizontalimageview(movie:MovieWithImages){

    LazyRow(modifier = Modifier.padding(8.dp)) {
        items(movie.movieImages.drop(1)) { image ->
            Card(modifier = Modifier.padding(end = 8.dp)) {
                AsyncImage(
                    model = image.url,
                    modifier = Modifier.size(178.dp),
                    contentScale = ContentScale.Crop,
                    contentDescription = "Movie Image"
                )
            }
        }
    }

}