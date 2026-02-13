package game.domain.di

import game.domain.usecases.GetGameDetailsUseCase
import game.domain.usecases.GetGamesUseCase
import org.koin.dsl.module

fun getGameDomainModule() = module {
    factory { GetGamesUseCase(gameRepository = get()) }
    factory { GetGameDetailsUseCase(gameRepository = get()) }
}