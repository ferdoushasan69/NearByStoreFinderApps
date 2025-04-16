package com.example.nearbystoreapps.navigation

import android.net.http.SslCertificate.saveState
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.nearbystoreapps.R
import com.example.nearbystoreapps.presentation.dashboard.DashBoard
import com.example.nearbystoreapps.ui.theme.PurpleGrey40

@Composable
fun Navigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    val list = listOf(
        BottomBarItem(label = "Home", icon = painterResource(R.drawable.btn_1)),
        BottomBarItem(label = "Support", icon = painterResource(R.drawable.btn_2)),
        BottomBarItem(label = "WishList", icon = painterResource(R.drawable.btn_3)),
        BottomBarItem(label = "Profile", icon = painterResource(R.drawable.btn_4)),
    )
    val screens = listOf(
        Home, Support, WishList, Profile
    )
    val isBottomBarVisible by remember { mutableStateOf(true) }
    val backStackEntry = navController.currentBackStackEntryFlow.collectAsState(null)
    val currentState = backStackEntry.value?.destination?.route
    var navBarState = screens.indexOfFirst { it::class.qualifiedName == currentState }

//    var selectedIndex by remember { mutableIntStateOf(0) }


    Scaffold(
        bottomBar = {
            AnimatedVisibility(visible = isBottomBarVisible) {
                NavigationBar(
                    containerColor = MaterialTheme.colors.background
                ) {
                    list.forEachIndexed { index,item->
                        NavigationBarItem(
                            colors = NavigationBarItemDefaults.colors(
                                selectedIconColor = PurpleGrey40,
                                unselectedIconColor = androidx.compose.material3.MaterialTheme.colorScheme.background,
                                indicatorColor = Color.Transparent // Removes background color
                            ),
                            interactionSource = MutableInteractionSource(),
                            selected = navBarState == index,
                            onClick = {
                                val targetRoute = screens[index]
                                if (currentState != targetRoute) {
                                    navBarState = index
                                    navController.navigate(targetRoute) {
                                        popUpTo(navController.graph.findStartDestination().id) {
                                            inclusive = false
                                        }
                                        launchSingleTop = true
                                        restoreState = false
                                    }
                                }


                            },
                            icon = {
                                Icon(
                                    painter = item.icon, contentDescription = item.label,
                                )
                            },
                            label = {
                                androidx.compose.material3.Text(
                                    item.label,
                                    color = MaterialTheme.colors.onBackground
                                )
                            }

                        )
                    }

                }
            }
        }
    ) {innerPadding->
        NavHost(navController = navController, startDestination = Home, modifier = Modifier.padding(innerPadding)){
            composable <Home>{
                DashBoard()
            }

            composable <Support>{
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                    Text("Support")
                }
            }
            composable <WishList>{
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                    Text("WishList")
                }
            }
            composable <Profile>{
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                    Text("Profile")
                }
            }
            composable <Result>{
                DashBoard()
            }
        }
    }



}

data class BottomBarItem(
    val label: String,
    val icon: Painter
)