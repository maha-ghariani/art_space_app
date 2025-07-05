package com.sesame.artspaceapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sesame.artspaceapp.ui.theme.ArtSpaceAppTheme

data class Artwork(val imageRes: Int, val title: String, val artist: String, val year: String)

private val artworks = listOf(
    Artwork(R.drawable.art1, "Composition", "Artist A", "2021"),
    Artwork(R.drawable.art2, "Monalisa", "Artist B", "2020"),
    Artwork(R.drawable.art3, "Color Study", "Artist C", "2019")
)

@Composable
fun ArtSpaceApp() {
    var currentIndex by remember { mutableStateOf(0) }
    val artwork = artworks[currentIndex]

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = artwork.imageRes),
                contentDescription = artwork.title,
                modifier = Modifier
                    .size(300.dp)
                    .padding(16.dp)
            )
            Text(text = artwork.title)
            Text(text = "${artwork.artist}, ${artwork.year}")
        }

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(onClick = {
                currentIndex = if (currentIndex > 0) currentIndex - 1 else artworks.lastIndex
            }) {
                Text("Previous")
            }
            Button(onClick = {
                currentIndex = if (currentIndex < artworks.lastIndex) currentIndex + 1 else 0
            }) {
                Text("Next")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    ArtSpaceAppTheme{
        ArtSpaceApp()
    }
}

