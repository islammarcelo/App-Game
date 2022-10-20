package com.example.appgame.ui.home


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items

import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.res.painterResource

import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.appgame.R
import com.example.appgame.data.remote.api.model.GameItem
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(navController: NavController) {
    val homeViewModel = hiltViewModel<HomeViewModel>()
    val state by homeViewModel.state.collectAsState()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    var text by remember {
        mutableStateOf("")
    }
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


    ModalDrawer(drawerContent = {
        Header(
            Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
        Body(navController,items = Items.values().toList()) {
            text = when (it) {
                Items.Favorite -> {
                    it.label
                }
            }
            scope.launch {
                drawerState.close()
            }
        }
    }, drawerState = drawerState) {
        Column() {
            Row(modifier = Modifier.padding(10.dp)) {
                IconButton(
                    onClick = { scope.launch { drawerState.open() } },
                ) {
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


}



