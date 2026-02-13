package di

import org.koin.dsl.module
import usecases.SearchGamesUseCase

fun getSearchDomainModule() = module {
    factory { SearchGamesUseCase(searchRepository = get()) }
}