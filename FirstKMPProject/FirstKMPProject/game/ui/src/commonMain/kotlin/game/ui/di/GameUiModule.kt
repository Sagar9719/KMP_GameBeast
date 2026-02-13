package game.ui.di

import game.ui.game.viewmodels.GameViewModel
import game.ui.gameDetails.viewmodels.GameDetailsViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

fun getGameUiModule() = module {
    viewModel { GameViewModel(gameUseCase = get()) }
    viewModel { GameDetailsViewModel(gameDetailsUseCase = get(), saveGameUseCase = get(), deleteUseCase = get()) }
}
