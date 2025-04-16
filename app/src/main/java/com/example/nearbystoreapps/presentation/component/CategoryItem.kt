package com.example.nearbystoreapps.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.nearbystoreapps.domain.CategoryModelUi


@Composable
fun CategorySection(modifier: Modifier = Modifier) {
    Text(
        "Explore Category",
        fontSize = 20.sp,
        fontWeight = FontWeight.SemiBold,
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .padding(top = 24.dp)
    )
}

@Composable
fun CategoryItem(
    categoryModel: CategoryModelUi,
    modifier: Modifier= Modifier,
    onCategoryClick: () -> Unit
) {

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = Color.White,
                shape = RoundedCornerShape(13.dp)
            )
            .padding(8.dp)
            .clickable(onClick = onCategoryClick),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        AsyncImage(
            model = categoryModel.imagePath,
            contentDescription = null,
            modifier = Modifier.height(65.dp)
        )

        Text(
            categoryModel.name, fontSize = 14.sp, fontWeight = FontWeight.SemiBold,
            color = Color.Black,
            modifier = Modifier.padding(top = 8.dp)
        )

    }

}