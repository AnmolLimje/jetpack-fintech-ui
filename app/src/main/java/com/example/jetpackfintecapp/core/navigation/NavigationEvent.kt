package com.example.jetpackfintecapp.core.navigation

/**
 * Best practice for Clean Architecture: Manage navigation events centrally.
 * This allows ViewModels to trigger navigation in a way that is testable 
 * and decoupled from the UI.
 */
sealed class NavigationEvent {
    data class Navigate(val route: String, val popUpToRoute: String? = null, val inclusive: Boolean = false) : NavigationEvent()
    object NavigateBack : NavigationEvent()
}
