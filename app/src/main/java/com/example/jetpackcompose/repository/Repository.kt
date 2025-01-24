package com.example.jetpackcompose.repository

import org.koin.dsl.module

interface Repository {
    fun getData(): String
}

class RepositoryImpl : Repository {
    override fun getData(): String {
        return "Repository"
    }
}

val repositoryModule = module {
    single<Repository> { RepositoryImpl() }
}