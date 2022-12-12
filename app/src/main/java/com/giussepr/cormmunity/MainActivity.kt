package com.giussepr.cormmunity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.giussepr.cormmunity.navigation.AppNavGraph
import com.giussepr.cormmunity.ui.theme.CormmunityTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            CormmunityTheme {
                AppNavGraph(navController)
            }
        }
    }
}
