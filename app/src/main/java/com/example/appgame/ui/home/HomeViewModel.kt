package com.example.appgame.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appgame.data.local.model.Game
import com.example.appgame.data.local.repository.LocalGameRepo
import com.example.appgame.data.remote.api.model.GameItem
import com.example.appgame.data.remote.repository.RemoteGameRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val remoteGameRepo: RemoteGameRepo, private val localGameRepo: LocalGameRepo
) : ViewModel() {

    private val _state = MutableStateFlow(emptyList<GameItem>())
    val state: StateFlow<List<GameItem>> get() = _state

    init {
        viewModelScope.launch {
            val games = remoteGameRepo.getGames()
            _state.value = games
        }
    }

    fun insertGame(game: Game){
        viewModelScope.launch {
            localGameRepo.insertGame(game)
        }
    }

    fun deleteGame(game: Game){
        viewModelScope.launch{
            localGameRepo.deleteGame(game)
        }
    }
}