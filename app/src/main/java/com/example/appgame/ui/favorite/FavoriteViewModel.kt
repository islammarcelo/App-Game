package com.example.appgame.ui.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appgame.data.local.model.Game
import com.example.appgame.data.local.repository.LocalGameRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val localGameRepo: LocalGameRepo
) : ViewModel() {
    private val _state = MutableStateFlow(emptyList<Game>())
    val state: StateFlow<List<Game>> get() = _state

    init {
        viewModelScope.launch {
            val games = localGameRepo.getGames()
            _state.value = games
        }
    }

    fun deleteGame(game: Game){
        viewModelScope.launch{
            localGameRepo.deleteGame(game)
        }
    }
}