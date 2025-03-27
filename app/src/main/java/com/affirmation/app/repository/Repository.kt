package com.affirmation.app.repository

import com.affirmation.app.R
import com.affirmation.app.viewModel.Game
import org.koin.dsl.module

interface Repository {
    suspend fun getGamesList(): Result<List<Game>>
}

class RepositoryImpl : Repository {
    override suspend fun getGamesList(): Result<List<Game>> = runCatching {
        listOf(
            Game(1, "Game 1", R.drawable.image5),
            Game(2, "Game 2", R.drawable.image4),
            Game(3, "Game 3", R.drawable.image6)
        )
    }
}

val repositoryModule = module {
    single<Repository> { RepositoryImpl() }
}