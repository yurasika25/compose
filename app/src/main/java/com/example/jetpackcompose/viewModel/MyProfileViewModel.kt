package com.example.jetpackcompose.viewModel

import android.content.res.Resources
import androidx.lifecycle.ViewModel
import com.example.jetpackcompose.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MyProfileViewModel(private val resources: Resources) : ViewModel() {

    private val _affirmationData = MutableStateFlow<String?>(null)
    val affirmationData: StateFlow<String?> = _affirmationData.asStateFlow()

    private fun calculateDigits(): String {
        return resources.getString(R.string.subtitle1)
    }

    fun onFollowClicked() {
        _affirmationData.value = calculateDigits()
    }
}