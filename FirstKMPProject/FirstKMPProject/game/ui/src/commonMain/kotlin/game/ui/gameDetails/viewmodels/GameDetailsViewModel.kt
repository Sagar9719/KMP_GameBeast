package game.ui.gameDetails.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import game.domain.model.GameDetails
import game.domain.usecases.DeleteUseCase
import game.domain.usecases.GetGameDetailsUseCase
import game.domain.usecases.SaveGameUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import util.log.KmpLogger

class GameDetailsViewModel(
    private val gameDetailsUseCase: GetGameDetailsUseCase,
    private val saveGameUseCase: SaveGameUseCase,
    private val deleteUseCase: DeleteUseCase
) : ViewModel() {
    data class UiState(
        val isLoading: Boolean = false,
        val error: String = "",
        val data: GameDetails? = null
    )

    private val _uiState = MutableStateFlow(value = UiState())
    val uiState = _uiState.asStateFlow()

    fun getGameDetails(id: Int) {
        gameDetailsUseCase.invoke(id = id)
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

    fun save(id: Int, image: String, name: String) = viewModelScope.launch {
        saveGameUseCase.invoke(id, image, name)
    }

    fun delete(id: Int) = viewModelScope.launch {
        deleteUseCase.invoke(id)
    }
}