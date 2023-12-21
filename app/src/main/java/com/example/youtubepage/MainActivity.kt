package com.example.youtubepage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.example.youtubepage.ui.theme.YouTubePageTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            YouTubePageTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    YouTubePage()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun YouTubePage() {
    var searchText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        TopAppBar(
            title = {
                BasicTextField(
                    value = searchText,
                    onValueChange = { searchText = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    textStyle = MaterialTheme.typography.displayMedium,
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Search
                    ),
                    decorationBox = { innerTextField ->

                        innerTextField()
                    }
                )
            },
            actions = {
                IconButton(
                    onClick = {

                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = null,
                        modifier = Modifier
                            .padding(4.dp)
                            .size(24.dp),
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            },
            modifier = Modifier.background(Color.White),
        )


        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Trending Videos",
            style = MaterialTheme.typography.displayMedium,
            modifier = Modifier.padding(8.dp)
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background)
        ) {
            items(10) { index ->
                VideoItem(videoTitle = "Trending Video $index")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Recommended Videos",
            style = MaterialTheme.typography.displayMedium,
            modifier = Modifier.padding(8.dp)
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background)
        ) {
            items(10) { index ->
                VideoItem(videoTitle = "Recommended Video $index")
            }
        }

    }
}

@Composable

fun VideoItem(videoTitle: String) {
    Card(
     modifier = Modifier
         .fillMaxSize()
         .padding(8.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp) )
     {
        Column {
            Image(
                painter = painterResource(id = R.drawable.flower),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(MaterialTheme.shapes.medium)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = videoTitle,
                style = MaterialTheme.typography.displayMedium,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}





