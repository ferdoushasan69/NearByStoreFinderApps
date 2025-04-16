package com.example.nearbystoreapps.presentation.results

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun ResultScreen(ViewModel: ResultViewModel = hiltViewModel()) {

    LazyColumn {
        item {
            ResultTopBar(title = "Title")
        }
    }
}