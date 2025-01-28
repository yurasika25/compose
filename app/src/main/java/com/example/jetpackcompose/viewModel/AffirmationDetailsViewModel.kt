package com.example.jetpackcompose.viewModel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcompose.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AffirmationDetailsViewModel(
    savedStateHandle: SavedStateHandle,
    private val repository: Repository
) : ViewModel() {

    private val _affirmationData = MutableStateFlow<AffirmationData?>(null)
    val affirmationData: StateFlow<AffirmationData?> = _affirmationData.asStateFlow()

    private val _gamesList = MutableStateFlow<List<Game>>(emptyList())
    val gamesList: StateFlow<List<Game>> = _gamesList.asStateFlow()

    init {
        _affirmationData.value = AffirmationData(
            title = savedStateHandle.get<String>("title") ?: "",
            imageResId = savedStateHandle.get<Int>("imageResId") ?: -1
        )
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            try {
                val games = withContext(Dispatchers.IO) { repository.getGamesList() }
                _gamesList.value = games
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}

data class AffirmationData(var title: String, var imageResId: Int)
data class Game(val id: Int? = null, val name: String? = null, val imageResId: Int? = null)