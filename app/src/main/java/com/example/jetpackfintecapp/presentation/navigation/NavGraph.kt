package com.example.jetpackfintecapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.jetpackfintecapp.presentation.onboarding.OnboardingScreen
import com.example.jetpackfintecapp.presentation.auth.LoginScreen
import com.example.jetpackfintecapp.presentation.main.MainScreen

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    startDestination: String = Screen.Onboarding.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Screen.Onboarding.route) {
            OnboardingScreen(
                onGetStartedClick = { navController.navigate(Screen.Login.route) },
                onSignInClick = { navController.navigate(Screen.Login.route) }
            )
        }
        composable(Screen.Login.route) {
            LoginScreen(
                onLoginSuccess = { 
                    navController.navigate(Screen.Main.route) {
                        popUpTo(Screen.Onboarding.route) { inclusive = true }
                    }
                },
                onNavigateToSignup = { /* Navigate to Signup */ }
            )
        }
        composable(Screen.Main.route) {
            MainScreen()
        }
    }
}
