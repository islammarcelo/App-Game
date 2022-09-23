package com.example.appgame.data.repository

import com.example.appgame.data.api.GameApi
import com.example.appgame.data.api.model.GameItem
import javax.inject.Inject

class GameRepo @Inject constructor(
    private val gameApi: GameApi
) {
    suspend fun getGames(): List<GameItem> {
        return gameApi.getGames()
    }
}