package di

import coreDatabase.AppDatabase
import org.koin.core.module.Module
import org.koin.dsl.module
import repository.FavouriteRepository
import repository.FavouriteRepositoryImpl

fun getFavouriteDataModule(): Module {
    return module {
        factory<FavouriteRepository> { FavouriteRepositoryImpl(appDatabase = get<AppDatabase>()) }
    }
}