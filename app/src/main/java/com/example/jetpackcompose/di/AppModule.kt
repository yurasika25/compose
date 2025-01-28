package com.example.jetpackcompose.di

import com.example.jetpackcompose.viewModel.AffirmationDetailsViewModel
import com.example.jetpackcompose.viewModel.GameViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModules = module {
    viewModel {
        AffirmationDetailsViewModel(get(), get())
    }
    viewModel {
        GameViewModel(get(), get())
    }
}