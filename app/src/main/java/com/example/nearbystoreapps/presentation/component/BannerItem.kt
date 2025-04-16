package com.example.nearbystoreapps.presentation.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.nearbystoreapps.domain.BannersModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Banner(
    snapshotStateList: List<BannersModel>,
    showBannerLoading: Boolean,
    modifier: Modifier = Modifier
) {
    if (showBannerLoading) {
        Box(modifier = Modifier
            .fillMaxSize()
            .height(200.dp), contentAlignment = Alignment.Center){}

    }else{
        BannerItem(
            bannersModel = snapshotStateList
        )
    }

}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun BannerItem(
    modifier: Modifier = Modifier,
    bannersModel: List<BannersModel>
) {
    val state = rememberPagerState()
    HorizontalPager(
        count = bannersModel.size,
        state = state,
    ) { page ->
        AsyncImage(
            model = bannersModel[page].image,
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp)
                .clip(RoundedCornerShape(10.dp))
                .height(200.dp)

        )
    }
}