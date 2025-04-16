package com.example.nearbystoreapps.presentation.results

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nearbystoreapps.R
import com.example.nearbystoreapps.ui.theme.BlueColor

@Composable
@Preview
fun ResultTopBar(modifier: Modifier = Modifier, title: String = "Title") {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .background(BlueColor)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center)
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(painter = painterResource(R.drawable.back),
                contentDescription = null, modifier = Modifier.clickable{})
            Text(
                text = "$title Store Result",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 20.sp,
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 16.dp)
            )

            Image(painter = painterResource(R.drawable.sample),contentDescription = null)
        }
    }

}