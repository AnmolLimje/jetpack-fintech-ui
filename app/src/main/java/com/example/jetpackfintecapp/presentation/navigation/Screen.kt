package com.example.jetpackfintecapp.presentation.navigation

sealed class Screen(val route: String) {
    object Onboarding : Screen("onboarding")
    object Login : Screen("login")
    object Signup : Screen("signup")
    object Main : Screen("main")
    
    // Bottom Nav Screens
    object Home : Screen("home")
    object Cards : Screen("cards")
    object Transfers : Screen("transfers")
    object More : Screen("more")
}
