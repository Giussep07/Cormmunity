package com.giussepr.cormmunity.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.giussepr.cormmunity.HomeScreen
import com.giussepr.cormmunity.LoginScreen
import com.giussepr.cormmunity.onboarding.NameScreen
import com.giussepr.cormmunity.onboarding.NicknameScreen
import com.giussepr.cormmunity.onboarding.PhotoScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.LoginScreen.route) {
        composable(AppScreens.LoginScreen.route) {
            LoginScreen(navController)
        }
        composable(AppScreens.NameScreen.route) {
            NameScreen(navController)
        }
        composable(AppScreens.NicknameScreen.route) {
            NicknameScreen(navController)
        }
        composable(AppScreens.PhotoScreen.route) {
            PhotoScreen(navController)
        }
        composable(AppScreens.HomeScreen.route) {
            HomeScreen(navController)
        }
    }
}