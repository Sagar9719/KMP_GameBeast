package game.data.di

import game.data.repository.GameRepositoryImpl
import game.domain.repository.GameRepository
import game.domain.usecases.DeleteUseCase
import game.domain.usecases.GetGameDetailsUseCase
import game.domain.usecases.SaveGameUseCase
import org.koin.dsl.module

fun getGamDataModule() = module {
    factory<GameRepository> { GameRepositoryImpl(apiService = get(), appDatabase = get()) }
    factory { GetGameDetailsUseCase(gameRepository = get()) }
    factory { SaveGameUseCase(gameRepository = get()) }
    factory { DeleteUseCase(gameRepository = get()) }
}