package com.example.jetpackcompose.di

import com.example.jetpackcompose.viewModel.ThirdViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModules = module {
    viewModel {
        ThirdViewModel(get(), get())
    }
}