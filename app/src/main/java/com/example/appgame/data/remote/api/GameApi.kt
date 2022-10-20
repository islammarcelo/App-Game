package com.example.appgame.data.remote.api

import com.example.appgame.data.remote.api.model.GameItem
import retrofit2.http.GET

interface GameApi {
    @GET(ApiConstants.GAMES_END_POINT)
    suspend fun getGames(): List<GameItem>
}