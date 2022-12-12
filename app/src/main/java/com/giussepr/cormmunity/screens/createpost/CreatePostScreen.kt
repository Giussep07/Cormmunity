package com.giussepr.cormmunity.screens.createpost

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.giussepr.cormmunity.CorTopAppBar
import com.giussepr.cormmunity.R

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewCreatePost() {
    CreatePostScreen(rememberNavController())
}

@Composable
fun CreatePostScreen(navController: NavHostController) {
    val postTypes = listOf(
        PostOption.Image,
        PostOption.Text
    )
    var postTypeSelected: PostOption? by remember { mutableStateOf(null) }
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var imageSelected by remember { mutableStateOf("") }
    var readyToCreate by remember { mutableStateOf(false) }

    readyToCreate = when (postTypeSelected) {
        PostOption.Image -> {
            title.isNotEmpty() && imageSelected.isNotEmpty()
        }
        PostOption.Text -> {
            title.isNotEmpty()
        }
        else -> title.isNotEmpty()
    }

    val titleMax = 300
    val descriptionMax = 500

    Scaffold(topBar = {
        CorTopAppBar(
            title = stringResource(id = R.string.create_post),
            navController = navController,
            actions = {
                TextButton(
                    onClick = { /*TODO*/ },
                    enabled = readyToCreate,
                    colors = ButtonDefaults.textButtonColors(contentColor = Color.White)
                ) {
                    Text(text = stringResource(id = R.string.next))
                }
            }
        )
    }) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
            ) {
                OutlinedTextField(
                    value = title,
                    placeholder = {
                        Text(
                            text = stringResource(id = R.string.create_post_hint),
                            style = MaterialTheme.typography.h6
                        )
                    },
                    onValueChange = { if (it.length <= titleMax) title = it },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.Transparent,
                        unfocusedBorderColor = Color.Transparent
                    ),
                    textStyle = MaterialTheme.typography.h6
                )

                when (postTypeSelected) {
                    PostOption.Image -> {
                        Button(
                            onClick = { imageSelected = "Holanda.png" },
                            modifier = Modifier.padding(start = 16.dp)
                        ) {
                            Text(text = "Agregar imagen")
                        }
                    }
                    PostOption.Text -> {
                        OutlinedTextField(
                            value = description,
                            placeholder = {
                                Text(
                                    text = stringResource(id = R.string.create_post_description_hint),
                                    style = MaterialTheme.typography.body1
                                )
                            },
                            onValueChange = { if (it.length <= descriptionMax) description = it },
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                focusedBorderColor = Color.Transparent,
                                unfocusedBorderColor = Color.Transparent
                            ),
                            textStyle = MaterialTheme.typography.body1
                        )
                    }
                    else -> {}
                }
            }
            Surface(elevation = 9.dp, modifier = Modifier.align(Alignment.BottomCenter)) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(2.dp)
                ) {
                    postTypes.forEach { postType ->
                        val icon = if (postTypes.any { postType == postTypeSelected }) {
                            postType.iconOn
                        } else {
                            postType.iconOff
                        }

                        IconButton(onClick = { postTypeSelected = postType }) {
                            Image(
                                painter = painterResource(id = icon),
                                contentDescription = stringResource(postType.contentDescription),
                            )
                        }
                        Spacer(Modifier.width(8.dp))
                    }
                }
            }
        }
    }
}

sealed class PostOption(
    @DrawableRes val iconOn: Int,
    @DrawableRes val iconOff: Int,
    @StringRes val contentDescription: Int
) {
    object Image : PostOption(
        R.drawable.ic_image_filled,
        R.drawable.ic_image_outlined,
        R.string.add_image_to_post
    )

    object Text : PostOption(
        R.drawable.ic_text_filled,
        R.drawable.ic_text_outlined,
        R.string.add_text_to_post
    )
}
