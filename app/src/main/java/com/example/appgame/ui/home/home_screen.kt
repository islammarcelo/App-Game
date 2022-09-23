package com.example.appgame.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import com.example.appgame.R
import com.example.appgame.data.api.model.GameItem
import java.util.*

@Composable
fun HomeScreen() {
    val homeViewModel = viewModel(modelClass = HomeViewModel::class.java)
    val state by homeViewModel.state.collectAsState()
    val categoryList =
        mutableListOf(
            "mmorpg",
            "shooter",
            "strategy",
            "moba",
            "racing",
            "sports",
            "social",
            "sandbox",
            "open - world",
            "survival",
            "pvp",
            "pve",
            "pixel",
            "voxel",
            "zombie",
            "turn - based",
            "first - person",
            "third - Person",
            "top - down",
            "tank",
            "space",
            "sailing",
            "side - scroller",
            "superhero",
            "permadeath",
            "card",
            "battle - royale",
            "mmo",
            "mmofps",
            "mmotps",
            "anime",
            "fantasy",
            "sci - fi",
            "fighting",
            "action - rpg",
            "action",
            "military",
            "martial - arts",
            "flight",
            "low - spec",
            "tower - defense",
            "horror",
            "mmorts"
        )

    Column() {
        Row(modifier = Modifier.padding(10.dp)) {
            IconButton(
                onClick = { },
            ){
                Icon(
                    painter = painterResource(id = R.drawable.menu),
                    contentDescription = null,
                    modifier = Modifier.size(50.dp)
                )
            }

        }

        LazyRow(modifier = Modifier.padding(5.dp)) {
            items(categoryList) { category -> CategoryButton(category = category) }
        }

        LazyColumn {
            if (state.isEmpty()) {
                item {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .fillMaxSize()
                            .wrapContentSize(align = Alignment.Center)
                    )
                }

            }

            items(state) { gameItem: GameItem ->
                GameImageCard(gameItem = gameItem)
            }


        }
    }


}

@Composable
fun CategoryButton(category: String) {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black),
        modifier = Modifier
            .padding(3.dp)
            .clip(RoundedCornerShape(10.dp))
    ) {
        Text(text = category, color = Color.White)
    }
}

@Composable
fun GameImageCard(gameItem: GameItem) {
    val imagerPainter = rememberImagePainter(data = gameItem.thumbnail)

    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .shadow(elevation = 1.dp)
            .padding(16.dp)
            .clip(RoundedCornerShape(5.dp))
    ) {
        Box {

            Column(modifier = Modifier.fillMaxSize()) {
                Row(Modifier.fillMaxWidth()) {
                    Image(
                        painter = imagerPainter,
                        contentDescription = "avatar",
                        contentScale = ContentScale.Crop,            // crop the image if it's not a square
                        modifier = Modifier
                            .padding(4.dp)
                            .size(64.dp)
                            .clip(CircleShape)                       // clip to the circle shape
                            .border(2.dp, Color.Black, CircleShape)   // add a border (optional)
                    )
                    Column(
                        modifier = Modifier
                            .weight(1f)

                            .padding(10.dp)
                    ) {
                        Text(text = "${gameItem.title}", fontSize = 20.sp)
                        Text(
                            "${gameItem.shortDescription}",
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            fontSize = 12.sp,
                            color = Color.Gray,
                            fontWeight = FontWeight.Light
                        )
                        Text(text = "Release Date: ${gameItem.releaseDate}", fontSize = 10.sp)
                    }
                    IconButton(
                        onClick = { },
                    ){
                        Icon(
                            painter = painterResource(R.drawable.heart),
                            contentDescription = null,
                            Modifier.size(20.dp)
                        )
                    }



                }
                Image(
                    painter = imagerPainter,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .padding(5.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .shadow(elevation = 5.dp),
                    contentScale = ContentScale.FillBounds
                )

            }


        }


    }


}