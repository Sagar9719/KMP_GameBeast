package coreNetwork.di

import coreNetwork.apiService.ApiService
import coreNetwork.client.KtorClient
import org.koin.dsl.module

fun getCoreNetworkModule() = module {
    single { ApiService(httpClient = KtorClient.getInstance()) }
}