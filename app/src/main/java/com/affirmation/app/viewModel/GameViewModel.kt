package com.affirmation.app.viewModel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.affirmation.app.repository.Repository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class GameViewModel(
    savedStateHandle: SavedStateHandle,
    private val repository: Repository
) : ViewModel() {

    private val _gameData = MutableStateFlow<String?>(null)
    val gameData: StateFlow<String?> = _gameData.asStateFlow()

    init {
        _gameData.value = savedStateHandle.get<String>("name") ?: ""
    }
}
