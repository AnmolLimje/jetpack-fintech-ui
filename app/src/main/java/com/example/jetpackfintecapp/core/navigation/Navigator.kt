package com.example.jetpackfintecapp.core.navigation

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

/**
 * Best practice for Clean Architecture: The Navigator is a singleton 
 * that ViewModels can use to send navigation events without knowing 
 * about the Jetpack Compose NavHost.
 */
class Navigator {
    private val _events = MutableSharedFlow<NavigationEvent>()
    val events = _events.asSharedFlow()

    suspend fun navigate(route: String, popUpToRoute: String? = null, inclusive: Boolean = false) {
        _events.emit(NavigationEvent.Navigate(route, popUpToRoute, inclusive))
    }

    suspend fun navigateBack() {
        _events.emit(NavigationEvent.NavigateBack)
    }
}
