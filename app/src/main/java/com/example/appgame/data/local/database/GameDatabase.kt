package com.example.appgame.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.appgame.data.local.dao.GameDao
import com.example.appgame.data.local.model.Game

@Database(entities = [Game::class], version = 2, exportSchema = false)
abstract class GameDatabase : RoomDatabase() {
    abstract fun gameDoa(): GameDao
}