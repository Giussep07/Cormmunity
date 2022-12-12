package com.giussepr.cormmunity

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.giussepr.cormmunity.navigation.AppScreens

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen(rememberNavController())
}

@Composable
fun LoginScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(Modifier.size(16.dp))
        Image(
            painter = painterResource(id = R.drawable.corhuila_logo),
            contentDescription = "Corhuila logo",
            modifier = Modifier.fillMaxWidth(0.5f)
        )
        Spacer(Modifier.size(32.dp))
        Button(onClick = { navController.navigate(AppScreens.NameScreen.route) }) {
            Text(text = "Login with Google")
        }
    }
}