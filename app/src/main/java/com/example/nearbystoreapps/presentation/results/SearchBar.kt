package com.example.nearbystoreapps.presentation.results

import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    text: String,
    onValueChangeText: (String) -> Unit
) {
    TextField(
        onValueChange = {},
        value = text
    )

}