package com.affirmation.app.di

import com.affirmation.app.viewModel.AffirmationDetailsViewModel
import com.affirmation.app.viewModel.GameViewModel
import com.affirmation.app.viewModel.MyProfileViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModules = module {
    viewModelOf(::AffirmationDetailsViewModel)
    viewModelOf(::GameViewModel)
    viewModelOf(::MyProfileViewModel)
}