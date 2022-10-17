package com.example.appgame.ui.home

import android.service.autofill.OnClickAction
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.appgame.R
import com.example.appgame.navigation.Screens
import kotlinx.coroutines.launch

enum class Items(val label:String, val icon: ImageVector){
    Favorite(label = "Favorite", Icons.Default.Favorite)
}

@Composable
fun Header(modifier: Modifier = Modifier){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Icon(painter = painterResource(id = R.drawable.game_splash), contentDescription = null)
        Spacer(modifier = Modifier.size(4.dp))
        Text(text = "App Games")
    }
}

@Composable
fun Body(navController: NavController,items:List<Items>, onClickItem: (Items) -> Unit){
    Column(modifier = Modifier.padding(8.dp)) {
        items.forEach{
            Row(modifier = Modifier.clickable {
                onClickItem.invoke(it)
                navController.navigate(Screens.Favorite.route)

            }) {
                Icon(imageVector = it.icon, contentDescription = null)
                Spacer(modifier = Modifier.size(8.dp))
                Text(text = it.label)
            }
            Spacer(modifier = Modifier.size(8.dp))
        }
    }
}