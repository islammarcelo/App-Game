package com.example.appgame.data.remote.repository

import com.example.appgame.data.remote.api.GameApi
import com.example.appgame.data.remote.api.model.GameItem
import javax.inject.Inject

class RemoteGameRepo @Inject constructor(
    private val gameApi: GameApi
) {
    suspend fun getGames(): List<GameItem> {
        return gameApi.getGames()
    }
}