package com.example.responsi_01.ui.screens.main

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.responsi_01.ui.screens.main.bottomscreens.account.AccountScreen
import com.example.responsi_01.ui.screens.main.bottomscreens.home.HomeScreen
import com.example.responsi_01.ui.screens.main.bottomscreens.logout.LogoutScreen
import com.example.responsi_01.ui.utils.Screens

@Composable
fun MainNavGraph(
    navController: NavHostController,
    onAccountMenuSelected: (String) -> Unit,
    onLogoutClick: () -> Unit,
) {
    NavHost(
        navController = navController,
        startDestination = Screens.HomeScreen.name
    ) {
        composable(route = Screens.HomeScreen.name) {
            HomeScreen()
        }
        composable(route = Screens.AccountScreen.name) {
            AccountScreen(onAccountMenuSelected = onAccountMenuSelected)
        }
        composable(route = Screens.LogoutScreen.name) {
            LogoutScreen(onLogoutClick = onLogoutClick)
        }
    }
}