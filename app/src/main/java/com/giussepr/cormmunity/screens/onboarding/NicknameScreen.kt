package com.giussepr.cormmunity.screens.onboarding

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
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
fun PreviewNicknameScreen() {
    NicknameScreen(rememberNavController())
}

@Composable
fun NicknameScreen(navController: NavHostController) {
    var nicknameText by rememberSaveable { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CorTopAppBar(title = stringResource(id = R.string.sign_up))
        Spacer(modifier = Modifier.size(24.dp))
        Text(
            text = stringResource(id = R.string.what_your_nickname_title),
            style = MaterialTheme.typography.h6
        )
        Spacer(modifier = Modifier.size(24.dp))
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            value = nicknameText,
            onValueChange = { nicknameText = it },
            label = { Text(text = stringResource(id = R.string.nickname)) })
        Spacer(modifier = Modifier.size(24.dp))
        Button(onClick = { navController.navigate(AppScreens.PhotoScreen.route) }) {
            Text(text = stringResource(id = R.string.next))
        }
    }
}