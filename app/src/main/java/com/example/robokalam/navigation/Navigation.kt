package com.robokalam.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import com.example.robokalam.navigation.Screen
import com.example.robokalam.ui.screens.SplashScreen
import com.robokalam.app.ui.screens.*
import com.example.robokalam.data.viewmodel.AppViewModel
import com.example.robokalam.ui.screens.AboutScreen

@Composable
fun Navigation(viewModel : AppViewModel, startDestination: String) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Splash.route) {
        composable(Screen.Splash.route) { SplashScreen(navController) }
        composable(Screen.Login.route) { LoginScreen(navController) }
        composable(Screen.Home.route) { HomeScreen(navController, viewModel) }
        composable(Screen.Portfolio.route) { PortfolioScreen(navController, viewModel) }
        composable(Screen.About.route) { AboutScreen() }
    }
}