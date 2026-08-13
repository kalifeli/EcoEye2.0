package com.example.ecoeyeapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ecoeyeapp.ui.ScreenServer

@Composable
fun NavGraph(){
    val context = LocalContext.current
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Schermate.ServerScreen.route){
        composable(route = Schermate.ServerScreen.route) { ScreenServer() }
    }
}