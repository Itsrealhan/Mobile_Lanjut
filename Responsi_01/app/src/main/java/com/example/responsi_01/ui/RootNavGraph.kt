package com.example.responsi_01.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.responsi_01.ui.screens.forgotpassword.ForgotPasswordScreen
import com.example.responsi_01.ui.screens.main.MainScreen
import com.example.responsi_01.ui.screens.notification.NotificationScreen
import com.example.responsi_01.ui.screens.privacypolicy.PrivacyPolicyScreen
import com.example.responsi_01.ui.screens.profile.ProfileScreen
import com.example.responsi_01.ui.screens.signin.SigninScreen
import com.example.responsi_01.ui.screens.signup.SignupScreen
import com.example.responsi_01.ui.screens.splash.SplashScreen
import com.example.responsi_01.ui.screens.termsofservice.TermsOfServiceScreen
import com.example.responsi_01.ui.utils.Screens

@Composable
fun MainNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screens.SplashScreen.name
    ) {
        composable(route = Screens.SplashScreen.name) {
            SplashScreen(
                onNavigateCallback = {
                    navController.popBackStack()
                    navController.navigate(route = Screens.SigninScreen.name)
                }
            )
        }
        composable(route = Screens.SigninScreen.name) {
            SigninScreen(
                onSigninClick = {
                    navController.popBackStack()
                    navController.navigate(route = Screens.MainScreen.name)
                },
                onSignupClick = { navController.navigate(route = Screens.SignupScreen.name) },
                onForgotPasswordClick = { navController.navigate(route = Screens.ForgotPasswordScreen.name) }
            )
        }
        composable(route = Screens.SignupScreen.name) {
            SignupScreen(
                onSigninClick = { navController.navigate(route = Screens.SigninScreen.name) },
                onSignupClick = {
                    navController.popBackStack()
                    navController.navigate(route = Screens.MainScreen.name)
                }
            )
        }
        composable(route = Screens.ForgotPasswordScreen.name) {
            ForgotPasswordScreen(
                onNavigateBack = { navController.navigateUp() }
            )
        }
        composable(route = Screens.MainScreen.name) {
            MainScreen(
                onAccountMenuSelected = { navController.navigate(route = it) },
                onLogoutClick = { navController.navigate(route = Screens.SigninScreen.name) }
            )
        }
        composable(route = Screens.ProfileScreen.name) {
            ProfileScreen(
                onNavigateBack = { navController.navigateUp() }
            )
        }
        composable(route = Screens.NotificationScreen.name) {
            NotificationScreen()
        }
        composable(route = Screens.PrivacyPolicyScreen.name) {
            PrivacyPolicyScreen()
        }
        composable(route = Screens.TermsOfServiceScreen.name) {
            TermsOfServiceScreen()
        }
    }
}