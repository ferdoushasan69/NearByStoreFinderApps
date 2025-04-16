package com.example.nearbystoreapps

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.nearbystoreapps.navigation.Navigation
import com.example.nearbystoreapps.presentation.dashboard.DashBoard
import com.example.nearbystoreapps.ui.theme.NearByStoreAppsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NearByStoreAppsTheme {
                Navigation()
            }
        }
    }
}


