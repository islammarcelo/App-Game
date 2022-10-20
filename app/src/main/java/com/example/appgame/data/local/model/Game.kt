package com.example.appgame.data.local.model

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "game", indices = [Index(value = ["gId"], unique = true)])
data class Game constructor(val title: String, val timeAdd: String, val image: String, val gId: Int){
    @PrimaryKey(autoGenerate = true)
    var id:Int=0
}