package com.giussepr.cormmunity.screens.home

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.giussepr.cormmunity.CorTopAppBar
import com.giussepr.cormmunity.R
import com.giussepr.cormmunity.navigation.AppScreens
import com.giussepr.cormmunity.navigation.HomeNavGraph

@Preview
@Composable
fun PreviewHomeScreen() {
    MainScreen()
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
        CorTopAppBar(title = stringResource(id = R.string.home), actions = {
            Icon(
                modifier = Modifier.padding(horizontal = 16.dp),
                painter = painterResource(id = R.drawable.ic_add),
                tint = Color.White,
                contentDescription = stringResource(id = R.string.create)
            )
        })
    }, bottomBar = { CorBottomNavigation(navController) }) { paddingValues ->
        HomeNavGraph(navController = navController, modifier = Modifier.padding(paddingValues))
    }
}

@Composable
fun CorBottomNavigation(navController: NavHostController) {
    val items = listOf(
        HomeBottomBarScreen.Home,
        HomeBottomBarScreen.Explore,
        HomeBottomBarScreen.Profile
    )

    BottomNavigation {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        items.forEach { screen ->
            BottomNavigationItem(
                icon = {
                    val iconResId =
                        if (currentDestination?.hierarchy?.any { it.route == screen.route } == true) {
                            screen.iconOn
                        } else {
                            screen.iconOff
                        }
                    Icon(
                        painter = painterResource(id = iconResId),
                        contentDescription = screen.route
                    )
                },
                selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                onClick = {
                    navController.navigate(screen.route) {
                        // Pop up to the start destination of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        // Avoid multiple copies of the same destination when
                        // reselecting the same item
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = true
                    }
                }
            )
        }
    }
}

private sealed class HomeBottomBarScreen(
    val route: String,
    @DrawableRes val iconOn: Int,
    @DrawableRes val iconOff: Int
) {
    object Home : HomeBottomBarScreen(
        route = AppScreens.HomeScreen.route,
        iconOn = R.drawable.ic_home_on,
        iconOff = R.drawable.ic_home_off
    )

    object Explore : HomeBottomBarScreen(
        route = AppScreens.ExploreScreen.route,
        iconOn = R.drawable.ic_explore_on,
        iconOff = R.drawable.ic_explore_off
    )

    object Profile : HomeBottomBarScreen(
        route = AppScreens.ProfileScreen.route,
        iconOn = R.drawable.ic_person_on,
        iconOff = R.drawable.ic_person_off
    )
}
