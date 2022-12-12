package com.giussepr.cormmunity

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.transform.CircleCropTransformation
import com.giussepr.cormmunity.ui.theme.PostIconColor

@Preview
@Composable
fun PreviewCorTopAppBar() {
    CorTopAppBar()
}

@Preview
@Composable
fun PreviewPostItem() {
    PostItem()
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

@Composable
fun PostItem() {
    val isText by remember { mutableStateOf(true) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = "https://styles.redditmedia.com/t5_2rn7o/styles/communityIcon_2083me9o3ia21.png",
                placeholder = painterResource(id = R.drawable.corhuila_logo),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(32.dp)
                    .clip(CircleShape)
                    .background(Color.LightGray)
            )
            Spacer(Modifier.size(8.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(text = "ingenieriaSistemas", style = MaterialTheme.typography.caption)
                Text(
                    text = stringResource(id = R.string.post_user_hours_ago, "giussepr", "20h"),
                    style = MaterialTheme.typography.caption.copy(fontWeight = FontWeight.Light),
                    color = Color.Gray
                )
            }
            Spacer(Modifier.size(8.dp))
            Button(
                modifier = Modifier.height(24.dp),
                contentPadding = PaddingValues(0.dp),
                onClick = { /*TODO*/ }) {
                Text(
                    text = stringResource(id = R.string.join),
                    style = MaterialTheme.typography.overline
                )
            }
        }
        // Title
        Text(
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
            style = MaterialTheme.typography.body1,
            modifier = Modifier.padding(horizontal = 8.dp)
        )
        // Description or Image
        if (isText) {
            Text(
                text = "Nam ligula ligula, fermentum ut diam in, convallis finibus nisl. Suspendisse pulvinar urna quis sapien tempus, ac commodo eros volutpat. Curabitur id eros id sapien blandit dictum et sit amet velit. Pellentesque ullamcorper vestibulum elit vitae consequat. Quisque ut neque neque. Praesent nec lacus vitae nisi finibus imperdiet in ut dolor. Praesent mollis condimentum tortor, ut fringilla nisl viverra eu. Phasellus luctus leo at tellus facilisis, eget vestibulum augue porta. Aliquam rhoncus nisl nec rhoncus pulvinar. Ut vitae nunc non tellus efficitur condimentum in eget mauris. Donec varius nec nunc sit amet tempus. Nulla placerat molestie pretium.",
                style = MaterialTheme.typography.caption,
                color = Color.Gray,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(8.dp)
            )
        } else {
            Spacer(Modifier.size(8.dp))
            // Image
            AsyncImage(
                model = "https://i.redd.it/2wwkxpdw6i5a1.jpg",
                placeholder = painterResource(id = R.drawable.corhuila_logo),
                contentDescription = null,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
        // Vote buttons
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row {
                Icon(
                    painter = painterResource(id = R.drawable.ic_vote_up_outlined),
                    contentDescription = stringResource(id = R.string.upvote),
                    tint = PostIconColor
                )
                Text(
                    text = "9364",
                    style = MaterialTheme.typography.body2,
                    color = Color.Gray,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_vote_down_filled),
                    contentDescription = stringResource(id = R.string.upvote),
                    tint = PostIconColor
                )
            }
            Spacer(Modifier.width(32.dp))
            Row {
                Icon(
                    painter = painterResource(id = R.drawable.ic_comments),
                    contentDescription = stringResource(id = R.string.upvote),
                    tint = PostIconColor
                )
                Text(
                    text = "9364",
                    style = MaterialTheme.typography.body2,
                    color = Color.Gray,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
            }
        }
    }
}
