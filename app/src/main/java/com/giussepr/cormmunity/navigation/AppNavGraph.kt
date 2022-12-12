package com.giussepr.cormmunity.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.giussepr.cormmunity.screens.home.MainScreen

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = AppGraph.HOME_GRAPH
    ) {
        loginNavGraph(navController)
        composable(route = AppGraph.HOME_GRAPH) {
            MainScreen()
        }
    }
}

object AppGraph {
    const val LOGIN_GRAPH = "login_graph"
    const val HOME_GRAPH = "home_graph"
    const val CREATE_POST_GRAPH = "create_post_graph"
}
