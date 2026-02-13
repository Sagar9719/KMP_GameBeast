package di

import org.koin.core.module.Module
import org.koin.dsl.module
import useCases.DeleteUseCase
import useCases.GetAllLocalCachedGamesUseCase
import useCases.UpsertUseCase

fun getFavoriteDomainModule(): Module {
    return module {
        factory { DeleteUseCase(favouriteRepository = get()) }
        factory { GetAllLocalCachedGamesUseCase(favouriteRepository = get()) }
        factory { UpsertUseCase(favouriteRepository = get()) }
    }
}