package com.example.jetpackcompose.di

import com.example.jetpackcompose.viewModel.MainViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModules = module {
    viewModel {
        MainViewModel(get(), get())
    }
}