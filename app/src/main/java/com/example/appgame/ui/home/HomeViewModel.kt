package com.example.appgame.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appgame.data.api.model.GameItem
import com.example.appgame.data.repository.GameRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val gameRepo: GameRepo
) : ViewModel() {

    private val _state = MutableStateFlow(emptyList<GameItem>())
    val state: StateFlow<List<GameItem>> get() = _state

    init {
        viewModelScope.launch {
            val games = gameRepo.getGames()
            _state.value = games
        }
    }

}