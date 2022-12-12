package com.giussepr.cormmunity.screens.onboarding

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.giussepr.cormmunity.CorTopAppBar
import com.giussepr.cormmunity.R
import com.giussepr.cormmunity.navigation.AppScreens

@Preview
@Composable
fun PreviewNameScreen() {
    NameScreen(rememberNavController())
}

@Composable
fun NameScreen(navController: NavHostController) {
    var nameText by rememberSaveable { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CorTopAppBar(title = stringResource(id = R.string.sign_up)) {
            IconButton(onClick = { navController.navigate(AppScreens.NicknameScreen.route) }) {
                Text(text = stringResource(id = R.string.skip))
            }
        }
        Spacer(modifier = Modifier.size(24.dp))
        Text(
            text = stringResource(id = R.string.what_your_name_title),
            style = MaterialTheme.typography.h6
        )
        Spacer(modifier = Modifier.size(24.dp))
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            value = nameText,
            onValueChange = { nameText = it },
            label = { Text(text = stringResource(id = R.string.name)) })
        Spacer(modifier = Modifier.size(24.dp))
        Button(onClick = { navController.navigate(AppScreens.NicknameScreen.route) }) {
            Text(text = stringResource(id = R.string.next))
        }
    }
}