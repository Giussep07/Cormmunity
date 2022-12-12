package com.giussepr.cormmunity

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun PreviewCorTopAppBar() {
    CorTopAppBar()
}

@Composable
fun CorTopAppBar(
    title: String = stringResource(id = R.string.app_name),
    actions: @Composable RowScope.() -> Unit = {}
) {
    TopAppBar(title = {
        Text(text = title)
    }, actions = actions)
}
