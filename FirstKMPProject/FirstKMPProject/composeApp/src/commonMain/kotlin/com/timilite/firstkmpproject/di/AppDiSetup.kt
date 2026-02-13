package com.timilite.firstkmpproject.di

import coreNetwork.di.getCoreNetworkModule
import di.getSearchDataModule
import di.getSearchDomainModule
import game.data.di.getGamDataModule
import game.domain.di.getGameDomainModule
import game.ui.di.getGameUiModule
import coreDatabase.di.getCoreDatabaseModule
import di.getFavoriteDomainModule
import di.getFavouriteDataModule
import di.getFavoriteUiModule
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import ui.di.getSearchUiModule

fun initKoin(koinApplication: ((KoinApplication) -> Unit)? = null) {
    startKoin {
        koinApplication?.invoke(this)
        modules(
            getCoreNetworkModule(),
            getGamDataModule(),
            getGameDomainModule(),
            getGameUiModule(),
            getSearchDataModule(),
            getSearchDomainModule(),
            getSearchUiModule(),
            getCoreDatabaseModule(),
            getFavoriteUiModule(),
            getFavouriteDataModule(),
            getFavoriteDomainModule()
        )
    }
}