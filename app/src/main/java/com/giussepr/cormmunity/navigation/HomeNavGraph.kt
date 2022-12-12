package com.giussepr.cormmunity.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.giussepr.cormmunity.screens.explore.ExploreScreen
import com.giussepr.cormmunity.screens.home.HomeScreen
import com.giussepr.cormmunity.screens.profile.ProfileScreen

@Composable
fun HomeNavGraph(navController: NavHostController, modifier: Modifier) {
    NavHost(
        navController = navController,
        route = AppGraph.HOME_GRAPH,
        startDestination = AppScreens.HomeScreen.route,
        modifier = modifier
    ) {
        composable(AppScreens.HomeScreen.route) {
            HomeScreen(navController)
        }
        composable(AppScreens.ExploreScreen.route) {
            ExploreScreen(navController)
        }
        composable(AppScreens.ProfileScreen.route) {
            ProfileScreen(navController)
        }
    }
}
