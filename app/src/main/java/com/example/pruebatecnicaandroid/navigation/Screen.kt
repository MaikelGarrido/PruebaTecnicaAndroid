package com.example.pruebatecnicaandroid.navigation

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Login : Screen("login")
    object Scaffold: Screen("scaffold")
}