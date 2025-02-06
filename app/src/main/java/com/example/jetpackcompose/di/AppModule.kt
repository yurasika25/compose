package com.example.jetpackcompose.di

import com.example.jetpackcompose.viewModel.AffirmationDetailsViewModel
import com.example.jetpackcompose.viewModel.GameViewModel
import com.example.jetpackcompose.viewModel.MyProfileViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModules = module {
    viewModelOf(::AffirmationDetailsViewModel)
    viewModelOf(::GameViewModel)
    viewModelOf(::MyProfileViewModel)
}