package com.example.nearbystoreapps.presentation.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.nearbystoreapps.presentation.component.Banner
import com.example.nearbystoreapps.presentation.component.CategoryItem
import com.example.nearbystoreapps.presentation.component.CategorySection
import com.example.nearbystoreapps.presentation.component.TopBar
import com.example.nearbystoreapps.ui.theme.BlueColor
import com.example.nearbystoreapps.ui.theme.LightBlue
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun DashBoard(viewModel: DashboardViewModel= hiltViewModel()) {

    val categories by viewModel.category.observeAsState(initial = emptyList())
    val banners by viewModel.banner.observeAsState(initial = emptyList())
    val isLoading = categories.isEmpty()
    var showCategoryLoading by remember { mutableStateOf(true) }
    val row = categories.chunked(3)
    LaunchedEffect(Unit) {
        viewModel.fetchCategory()
    }

    LaunchedEffect(Unit) {
        viewModel.fetchBanners()

    }
    val systemBarColor = rememberSystemUiController()
    systemBarColor.setStatusBarColor(BlueColor)
    Scaffold {innerPadding->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(LightBlue)
        ) {
            item { TopBar() }
            item {
                Banner(
                    snapshotStateList = banners,
                    showBannerLoading = banners.isEmpty(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )

            }
            item { CategorySection() }
            if (isLoading) {
                item {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                            .wrapContentWidth(Alignment.CenterHorizontally)
                    )
                }
            } else {
                items(row) { categoryRow ->

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp, vertical = 4.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        // Iterate through each category and show it
                        categoryRow.forEach { category ->
                            CategoryItem(
                                categoryModel = category,
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(horizontal = 8.dp)
                            ) {}
                        }

                        // Add spacers to fill the remaining space in the row
                        val remainingSpaces = 3 - categoryRow.size
                        repeat(remainingSpaces) {
                            Spacer(modifier = Modifier
                                .weight(1f)
                                .padding(4.dp))
                        }
                    }

                }
            }

        }
    }
}