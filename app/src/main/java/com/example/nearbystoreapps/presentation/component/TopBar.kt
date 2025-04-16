package com.example.nearbystoreapps.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.nearbystoreapps.R
import com.example.nearbystoreapps.ui.theme.BlueColor

@Composable
@Preview(showSystemUi = true)
fun TopBar() {
    val horizontalPadding = 16.dp
    val verticalPadding = 16.dp

    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        val (blueBox, title1, title2, profile, building, whiteBox) = createRefs()
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(255.dp)
                .background(BlueColor)
                .constrainAs(blueBox) {
                    top.linkTo(parent.top)
                }
        )

        Image(
            painter = painterResource(R.drawable.building), contentDescription = null,
            modifier = Modifier
                .size(30.dp)
                .clip(CircleShape)
                .constrainAs(building) {
                bottom.linkTo(blueBox.bottom)
            }

        )

        Image(
            painter = painterResource(R.drawable.profile), contentDescription = null,
            modifier = Modifier
                .padding(horizontal = horizontalPadding, vertical = verticalPadding)
                .constrainAs(profile) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                })

        Text(
            "Good Morning ,Olivia",
            fontSize = 20.sp,
            color = Color.White,
            modifier = Modifier.constrainAs(title1) {
                top.linkTo(profile.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            })


        Text(
            "What are you doing today ?",
            fontSize = 25.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.constrainAs(title2) {
                top.linkTo(title1.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            })

        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
                .height(110.dp)
                .background(Color.White, shape = RoundedCornerShape(10.dp))
                .constrainAs(whiteBox) {
                    top.linkTo(blueBox.bottom)
                    bottom.linkTo(blueBox.bottom)
                }
                .clip(RoundedCornerShape(10.dp))
        ) {

            val (icon1,icon2,balance,reward,amount,wallet,arrow1,arrow2,arrow3,line1,line2) = createRefs()
            Image(painter = painterResource(R.drawable.wallet), contentDescription = null, modifier = Modifier
                .padding(top = horizontalPadding, start =  verticalPadding)
                .constrainAs (icon1){
                top.linkTo(parent.top)
                start.linkTo(parent.start)
            })
            Text("Wallet",
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier.constrainAs (wallet){
                bottom.linkTo(icon1.bottom)
                start.linkTo(icon1.end,8.dp)
            })

         Image(painter = painterResource(R.drawable.arrow),contentDescription = null, modifier = Modifier
             .padding(start = horizontalPadding)
             .constrainAs (arrow1){
             top.linkTo(wallet.top)
             start.linkTo(wallet.end)
             bottom.linkTo(wallet.bottom)
         })

            Image(painter = painterResource(R.drawable.medal), contentDescription = null, modifier = Modifier
                .padding(start = horizontalPadding, bottom =  verticalPadding)
                .constrainAs (icon2){
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                })
            Text("Medal",
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier.constrainAs (reward){
                    top.linkTo(icon2.top)
                    start.linkTo(icon2.end,8.dp)
                })

            Image(painter = painterResource(R.drawable.arrow),contentDescription = null, modifier = Modifier
                .padding(start = horizontalPadding)
                .constrainAs (arrow2){
                    top.linkTo(reward.top)
                    start.linkTo(reward.end)
                    bottom.linkTo(reward.bottom)
                })

            Box(
                modifier = Modifier
                    .width(1.dp)
                    .fillMaxHeight()
                    .padding(vertical = verticalPadding)
                    .background(Color.LightGray)
                    .constrainAs (line1){
                        centerTo(parent)
                    }
            )
            Box(
                modifier = Modifier.height(1.dp).width(170.dp)
                    .padding(horizontal = horizontalPadding)
                    .background(Color.LightGray)
                    .constrainAs(line2){
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                }
            )

            Text(text = "Balance",
                fontSize = 14.sp,
                textDecoration = TextDecoration.Underline,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                .padding(start = verticalPadding, top = 32.dp)
                .constrainAs (balance){
                top.linkTo(parent.top)
                start.linkTo(line1.end)
            })

            Text(text = "1500.00 USD",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(top = 8.dp, start = horizontalPadding)
                    .constrainAs (amount){
                        top.linkTo(balance.bottom)
                        start.linkTo(balance.start)
                    })

            Image(painter = painterResource(R.drawable.arrow),contentDescription = null, modifier = Modifier
                .padding(start = horizontalPadding)
                .constrainAs (arrow3){
                    top.linkTo(amount.top)
                    start.linkTo(amount.end)
                    bottom.linkTo(amount.bottom)
                })
        }
    }

}