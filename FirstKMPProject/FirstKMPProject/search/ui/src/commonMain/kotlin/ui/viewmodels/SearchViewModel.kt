package ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import model.Game
import usecases.SearchGamesUseCase
import util.log.KmpLogger

class SearchViewModel(
    private val searchGamesUseCase: SearchGamesUseCase
) : ViewModel() {
    data class UiState(
        val isLoading: Boolean = false,
        val data: List<Game> = emptyList(),
        val error: String? = null
    )

    private val _uiState = MutableStateFlow(value = UiState())
    val uiState = _uiState.asStateFlow()
    private val _query = MutableStateFlow(value = "")

    init {
        initSearch()
    }

    fun onSearch(query: String) {
        _query.update { query }
    }

    @OptIn(FlowPreview::class)
    private fun initSearch() {
        viewModelScope.launch {
            _query.filter { it.isNotBlank() }
                .distinctUntilChanged()
                .debounce(timeoutMillis = 500)
                .collectLatest { query ->
                    search(query = query)
                }
        }
    }

    private fun search(query: String) = searchGamesUseCase.invoke(query = query)
        .onStart {
            _uiState.update { UiState(isLoading = true) }
        }.onEach { result ->
            result.onSuccess { data ->
                KmpLogger.d("ChedkSearchData","data: $data")
                _uiState.update { UiState(data = data) }
            }.onFailure { error ->
                KmpLogger.d("ChedkSearchData","error: $error")
                _uiState.update { UiState(error = error.message.toString()) }
            }
        }.launchIn(viewModelScope)
}