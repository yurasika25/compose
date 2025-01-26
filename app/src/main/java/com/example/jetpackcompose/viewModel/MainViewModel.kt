package com.example.jetpackcompose.viewModel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.jetpackcompose.repository.Repository
import kotlinx.coroutines.flow.MutableStateFlow

class MainViewModel(
    savedStateHandle: SavedStateHandle,
    repository: Repository
) : ViewModel() {

    val title = MutableStateFlow("")
    val imageResId = MutableStateFlow(-1)

    init {
        title.value = savedStateHandle.get<String>("title") ?: ""
        imageResId.value = savedStateHandle.get<Int>("imageResId") ?: -1
//        title.value = repository.getData()
    }
}