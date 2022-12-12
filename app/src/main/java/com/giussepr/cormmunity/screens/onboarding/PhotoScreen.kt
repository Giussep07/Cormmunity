package com.giussepr.cormmunity.screens.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.giussepr.cormmunity.CorTopAppBar
import com.giussepr.cormmunity.R
import com.giussepr.cormmunity.navigation.AppGraph
import com.giussepr.cormmunity.navigation.AppScreens

@Preview
@Composable
fun PreviewPhotoScreen() {
    PhotoScreen(rememberNavController())
}

@Composable
fun PhotoScreen(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        CorTopAppBar(title = stringResource(id = R.string.sign_up)) {
            IconButton(onClick = { navigateToHome(navController) }) {
                Text(text = stringResource(id = R.string.skip))
            }
        }
        Spacer(modifier = Modifier.size(24.dp))
        Text(
            text = stringResource(id = R.string.photo_profile),
            style = MaterialTheme.typography.h6
        )
        Spacer(modifier = Modifier.size(24.dp))
        Image(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .clip(CircleShape),
            painter = painterResource(id = R.drawable.avatar_placeholder),
            contentDescription = stringResource(id = R.string.photo_profile)
        )
        Spacer(modifier = Modifier.size(24.dp))
        Button(onClick = { navigateToHome(navController) }) {
            Text(text = stringResource(id = R.string.next))
        }
    }
}

private fun navigateToHome(navController: NavHostController) {
    navController.navigate(AppGraph.HOME_GRAPH) {
        popUpTo(0) { inclusive = true }
    }
}
