package com.example.appgame.data.local.repository

import androidx.annotation.WorkerThread
import com.example.appgame.data.local.dao.GameDao
import com.example.appgame.data.local.model.Game
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LocalGameRepo @Inject constructor(private val gameDao: GameDao) {


    suspend fun getGames(): List<Game> {
        return gameDao.getAllGames()
    }

    suspend fun insertGame(game: Game){
        gameDao.insertGame(game)
    }

    suspend fun deleteGame(game: Game){
        gameDao.deleteGame(game)
    }
}