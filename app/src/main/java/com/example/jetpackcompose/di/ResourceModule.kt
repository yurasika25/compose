package com.example.jetpackcompose.di

import android.content.Context
import android.content.res.Resources
import org.koin.dsl.module

val resModule = module { single<Resources> { get<Context>().resources } }