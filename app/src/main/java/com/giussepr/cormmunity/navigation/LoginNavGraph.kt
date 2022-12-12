package com.giussepr.cormmunity.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.giussepr.cormmunity.LoginScreen
import com.giussepr.cormmunity.screens.onboarding.NameScreen
import com.giussepr.cormmunity.screens.onboarding.NicknameScreen
import com.giussepr.cormmunity.screens.onboarding.PhotoScreen

fun NavGraphBuilder.loginNavGraph(navController: NavHostController) {
    navigation(route = AppGraph.LOGIN_GRAPH, startDestination = AppScreens.LoginScreen.route) {
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
    }
}
