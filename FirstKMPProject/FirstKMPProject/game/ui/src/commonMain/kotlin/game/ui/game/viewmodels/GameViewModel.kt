package game.ui.game.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import game.domain.usecases.GetGamesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import model.Game

class GameViewModel(
    private val gameUseCase: GetGamesUseCase
): ViewModel() {
    data class UiState(
        val isLoading: Boolean = false,
        val error: String = "",
        val data: List<Game>? = null
    )

    private val _uiState = MutableStateFlow(value = UiState())
    val uiState = _uiState.asStateFlow()

    fun getGames() = gameUseCase.invoke()
        .onStart {
            _uiState.update { UiState(isLoading = true) }
        }.onEach { result ->
            result.onSuccess { data ->
                _uiState.update { UiState(data = data) }
            }.onFailure { error ->
                _uiState.update { UiState(error = error.message.toString()) }
            }
        }.launchIn(viewModelScope)
}