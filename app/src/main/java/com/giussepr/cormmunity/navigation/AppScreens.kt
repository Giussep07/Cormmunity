package com.giussepr.cormmunity.navigation

sealed class AppScreens(val route: String) {
    object LoginScreen: AppScreens("login_screen")
    object NameScreen: AppScreens("name_screen")
    object NicknameScreen: AppScreens("nickname_screen")
    object PhotoScreen: AppScreens("photo_screen")
    object HomeScreen :AppScreens("home_screen")
    object ExploreScreen :AppScreens("explore_screen")
    object ProfileScreen :AppScreens("Profile_screen")
}
