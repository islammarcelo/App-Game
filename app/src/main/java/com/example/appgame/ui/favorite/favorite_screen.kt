package com.example.appgame.ui.favorite

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.appgame.R
import com.example.appgame.data.local.model.Game
import com.example.appgame.data.remote.api.model.GameItem
import com.example.appgame.navigation.Screens
import com.example.appgame.ui.home.GameImageCard
import com.example.appgame.ui.home.HomeViewModel

@Composable
fun FavoriteScreen(navController: NavController) {
    val favoriteViewModel = hiltViewModel<FavoriteViewModel>()
    val state by favoriteViewModel.state.collectAsState()
    Column() {
        Row(horizontalArrangement = Arrangement.Center,modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)) {
            Text(text = "Favorites", fontSize = 30.sp, fontWeight = FontWeight.Bold)
        }

            LazyColumn {
                items(state) { game: Game ->
                    FavoriteGameImageCard(game = game, favoriteViewModel)
                }


            }
        }




}

@Composable
fun FavoriteGameImageCard(game: Game, favoriteViewModel:FavoriteViewModel) {
    val imagerPainter = rememberImagePainter(data = game.image)
    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .shadow(elevation = 1.dp)
            .padding(16.dp)
            .clip(RoundedCornerShape(5.dp))
    ){
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
                        Text(text = "${game.title}", fontSize = 20.sp)

                        Text(text = "Added Date: ${game.timeAdd}", fontSize = 10.sp)
                    }


                    IconButton(
                        onClick = {
                            favoriteViewModel.deleteGame(game)
                        },

                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.like ),
                            contentDescription = null,
                            Modifier.size(20.dp)
                        )
                    }


                }


            }


        }
    }

}
