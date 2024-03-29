package com.example.movieappmad24.widget

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun NameField() {
    var name by remember {
        mutableStateOf("")
    }
    Column {
        Text(text = "Hello $name !")
        OutlinedTextField(value = name,
            onValueChange = { name = it },
            label = { Text(text = "Name") })
    }
}