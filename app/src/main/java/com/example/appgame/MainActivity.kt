package com.example.appgame
import NavGraph
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface

import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController

import com.example.appgame.ui.theme.AppGameTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppGameTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize()) {
//                    HomeScreen()
                    val navController = rememberNavController()
                    NavGraph(navController = navController)
                }
            }
        }
    }
}
