package com.example.appgame.ui.home

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.example.appgame.R
import com.example.appgame.data.local.model.Game
import com.example.appgame.data.remote.api.model.GameItem
import com.example.appgame.ui.favorite.FavoriteViewModel


@Composable
fun GameImageCard(gameItem: GameItem) {
    val homeViewModel = hiltViewModel<HomeViewModel>()
    val imagerPainter = rememberImagePainter(data = gameItem.thumbnail)
    val interactionSource = remember { MutableInteractionSource() }
//    val isPressed by interactionSource.collectIsPressedAsState()
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
                    var isPressed by remember { mutableStateOf(false) }

                    IconButton(
                        onClick = {
                            val game = Game(gameItem.title,gameItem.releaseDate,gameItem.thumbnail,gameItem.id)
                            if (!isPressed) {
                                homeViewModel.insertGame(game)
                                Log.d("msg","Add GAme")
                            }
                            else if (isPressed){
                                 homeViewModel.deleteGame(game)
                                Log.d("msg","delete GAme")
                            }
                            isPressed = !isPressed
                        },
                        interactionSource = interactionSource,
                    ) {
                        Icon(
                            painter = painterResource(id = if (isPressed) R.drawable.like else R.drawable.dis_like),
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