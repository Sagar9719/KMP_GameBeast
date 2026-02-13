package di

import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import viewmodels.FavouriteViewModel

fun getFavoriteUiModule(): Module {
    return module {
        viewModel { FavouriteViewModel(
            getAllLocalCachedGamesUseCase = get(),
            deleteUseCase = get()
        ) }
    }
}
