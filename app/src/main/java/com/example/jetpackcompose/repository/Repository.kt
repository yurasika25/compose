package com.example.jetpackcompose.repository

import com.example.jetpackcompose.R
import com.example.jetpackcompose.viewModel.Game
import org.koin.dsl.module

interface Repository {
    suspend fun getGamesList(): List<Game>
}

class RepositoryImpl : Repository {
    override suspend fun getGamesList(): List<Game> {
        return listOf(
            Game(1, "Game 1", R.drawable.image5),
            Game(2, "Game 2", R.drawable.image4),
            Game(3, "Game 3", R.drawable.image6)
        )
    }
}

val repositoryModule = module {
    single<Repository> { RepositoryImpl() }
}