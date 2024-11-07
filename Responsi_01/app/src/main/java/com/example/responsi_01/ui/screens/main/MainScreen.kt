package com.example.responsi_01.ui.screens.main

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.responsi_01.R
import com.example.responsi_01.ui.utils.Screens

@Composable
fun MainScreen(
    onAccountMenuSelected: (String) -> Unit,
    onLogoutClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val navController: NavHostController = rememberNavController()
    val navBackStackEntry: NavBackStackEntry? by navController.currentBackStackEntryAsState()
    val currentDestination: NavDestination? = navBackStackEntry?.destination

    val navItems: List<NavItem> = listOf(
        NavItem(
            label = R.string.home,
            selectedIcon = R.drawable.home_filled_24px,
            unselectedIcon = R.drawable.home_24px,
            route = Screens.HomeScreen.name
        ),
        NavItem(
            label = R.string.akun,
            selectedIcon = R.drawable.person_filled_24px,
            unselectedIcon = R.drawable.person_24px,
            route = Screens.AccountScreen.name
        ),
        NavItem(
            label = R.string.logout,
            selectedIcon = R.drawable.exit_to_app_24px,
            unselectedIcon = R.drawable.exit_to_app_24px,
            route = Screens.LogoutScreen.name
        )
    )

    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                currentDestination = currentDestination,
                navItems = navItems,
                onNavItemSelected = { navController.navigate(route = it) },
                modifier = Modifier.fillMaxWidth()
            )
        },
        modifier = modifier
    ) { innerPadding ->
        Box(
            modifier = Modifier.padding(paddingValues = innerPadding)
        ) {
            MainNavGraph(
                navController = navController,
                onAccountMenuSelected = onAccountMenuSelected,
                onLogoutClick = onLogoutClick
            )
        }
    }
}

@Composable
private fun BottomNavigationBar(
    currentDestination: NavDestination?,
    navItems: List<NavItem>,
    onNavItemSelected: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    NavigationBar(modifier = modifier) {
        navItems.forEach { navItem ->
            val selected = currentDestination?.hierarchy?.any {
                navItem.route == it.route
            } == true
            
            val icon = if (selected) {
                navItem.selectedIcon
            } else { navItem.unselectedIcon }
            
            NavigationBarItem(
                selected = selected,
                onClick = { onNavItemSelected(navItem.route) },
                icon = { 
                    Icon(
                        painter = painterResource(id = icon), 
                        contentDescription = stringResource(id = navItem.label)
                    )
                },
                label = {
                    Text(
                        text = stringResource(id = navItem.label),
                        style = MaterialTheme.typography.bodySmall
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.primary,
                    unselectedIconColor = MaterialTheme.colorScheme.outline,
                    selectedTextColor = MaterialTheme.colorScheme.primary,
                    unselectedTextColor = MaterialTheme.colorScheme.outline,
                    indicatorColor = Color.Transparent,
                )
            )
        }
    }
}

data class NavItem(
    @StringRes val label: Int,
    @DrawableRes val selectedIcon: Int,
    @DrawableRes val unselectedIcon: Int,
    val route: String
)