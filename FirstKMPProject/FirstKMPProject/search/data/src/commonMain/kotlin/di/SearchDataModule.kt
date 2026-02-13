package di

import org.koin.dsl.module
import repository.SearchRepository
import repository.SearchRepositoryImpl

fun getSearchDataModule() = module {
    factory<SearchRepository> { SearchRepositoryImpl(apiService = get()) }
}