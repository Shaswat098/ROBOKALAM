package com.example.robokalam.navigation

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Login : Screen("login")
    object Home : Screen("home")
    object Portfolio : Screen("portfolio")
    object About : Screen("about")
}
