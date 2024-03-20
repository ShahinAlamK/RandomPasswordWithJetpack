package com.example.randompassword.navGraph
sealed class RouteItem(val route : String) {
    data object SplashScreen: RouteItem("splash_screen")
    data object HomeScreen: RouteItem("home_screen")
}