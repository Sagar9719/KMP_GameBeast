package ui.di

import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import ui.viewmodels.SearchViewModel

fun getSearchUiModule() = module {
    viewModel { SearchViewModel(searchGamesUseCase = get()) }
}