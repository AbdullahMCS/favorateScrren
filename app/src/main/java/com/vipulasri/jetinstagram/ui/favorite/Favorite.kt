package com.vipulasri.jetinstagram.ui.favorite

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.vipulasri.jetinstagram.data.FavoriteRepository
import com.vipulasri.jetinstagram.data.StoriesRepository
import com.vipulasri.jetinstagram.model.User
import com.vipulasri.jetinstagram.ui.theme.color1

@Composable
fun FavoriteScreen() {
    Scaffold(
        topBar = { Toolbar() }) {
        val users by FavoriteRepository.observeStories()
        Column {
            SomeText()
            SearchBar()
            FavList(usersList = users)
        }
    }
}

@Composable
private fun Toolbar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(horizontal = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.Close,
            contentDescription = ""
        )
        Text(
            text = "Favorites",
            style = MaterialTheme.typography.h6
        )
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = ""
        )
    }
}

@Composable
private fun SomeText() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color1)
    ) {
        Text(
            text = "New posts from your favorites will appear higher in feed. " +
                    "Only you can see who you add or remove. How it works",
            modifier = Modifier
                .paddingFromBaseline(top = 16.dp, bottom = 16.dp)
                .padding(start = 16.dp, end = 16.dp),
            style = MaterialTheme.typography.body1,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
private fun SearchBar() {
    Box(contentAlignment = Alignment.Center, modifier = Modifier.padding(16.dp)) {
        TextField(
            value = "",
            onValueChange = { },
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 56.dp),
            leadingIcon = {
                Icon(imageVector = Icons.Default.Search, contentDescription = null)
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(),
            placeholder = { Text("Search") }
        )
    }
}

@Composable
private fun FavItem(
    image: String,
    name: String,
    userName: String
) {
    Row() {
        Image(
            painter = rememberImagePainter(image),
            contentDescription = null,
            Modifier.size(width = 80.dp, height = 80.dp)
        )
        Column() {
            Text(text = name)
            Text(text = userName)
        }
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Add")
        }
    }
}

@Composable
private fun FavList(usersList: List<User>) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        itemsIndexed(usersList) { index, user ->
            FavItem(image = user.image, name = user.name, userName = user.username)
        }
    }
}

@Preview
@Composable
fun ThePreview() {
    FavoriteScreen()
}