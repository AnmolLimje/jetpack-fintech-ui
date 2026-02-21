package com.example.jetpackfintecapp.presentation.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.jetpackfintecapp.presentation.cards.CardsScreen
import com.example.jetpackfintecapp.presentation.home.HomeScreen
import com.example.jetpackfintecapp.presentation.home.HomeViewModel
import com.example.jetpackfintecapp.presentation.navigation.Screen
import com.example.jetpackfintecapp.presentation.transfers.TransfersScreen
import com.example.jetpackfintecapp.domain.usecase.GetCardsUseCase
import com.example.jetpackfintecapp.data.repository.CardRepositoryImpl
import com.example.jetpackfintecapp.data.mock.FakeCardRemoteDataSource

sealed class BottomNavItem(val screen: Screen, val title: String, val icon: ImageVector) {
    object Home : BottomNavItem(Screen.Home, "Home", Icons.Default.Home)
    object Cards : BottomNavItem(Screen.Cards, "Cards", Icons.Default.ShoppingCart)
    object Transfers : BottomNavItem(Screen.Transfers, "Transfers", Icons.Default.Menu)
    object More : BottomNavItem(Screen.More, "More", Icons.Default.Person)
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Cards,
        BottomNavItem.Transfers,
        BottomNavItem.More
    )

    // Manual Injection (Use Hilt in real projects)
    val fakeDataSource = FakeCardRemoteDataSource()
    val repository = CardRepositoryImpl(fakeDataSource)
    val getCardsUseCase = GetCardsUseCase(repository)
    val homeViewModel = HomeViewModel(getCardsUseCase)

    Scaffold(
        bottomBar = {
            NavigationBar {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                items.forEach { item ->
                    NavigationBarItem(
                        icon = { Icon(item.icon, contentDescription = item.title) },
                        label = { Text(item.title) },
                        selected = currentDestination?.hierarchy?.any { it.route == item.screen.route } == true,
                        onClick = {
                            navController.navigate(item.screen.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route) { 
                HomeScreen(viewModel = homeViewModel) 
            }
            composable(Screen.Cards.route) { 
                CardsScreen() 
            }
            composable(Screen.Transfers.route) { 
                TransfersScreen() 
            }
            composable(Screen.More.route) { 
                /* Profile/More Screen */ 
            }
        }
    }
}
