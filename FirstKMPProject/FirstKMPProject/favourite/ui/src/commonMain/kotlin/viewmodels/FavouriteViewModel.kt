package viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import useCases.DeleteUseCase
import useCases.GetAllLocalCachedGamesUseCase

class FavouriteViewModel(
    private val getAllLocalCachedGamesUseCase: GetAllLocalCachedGamesUseCase,
    private val deleteUseCase: DeleteUseCase
) : ViewModel() {
    val games = getAllLocalCachedGamesUseCase.invoke().stateIn(
        viewModelScope, started = SharingStarted.WhileSubscribed(),emptyList()
    )

    fun delete(id:Int) = viewModelScope.launch {
        deleteUseCase.invoke(id)
    }
}