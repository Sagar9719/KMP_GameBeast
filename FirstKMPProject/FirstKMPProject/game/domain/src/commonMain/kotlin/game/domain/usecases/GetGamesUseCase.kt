package game.domain.usecases

import game.domain.repository.GameRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GetGamesUseCase(
    private val gameRepository: GameRepository
) {
    operator fun invoke() = flow {
        emit(value = gameRepository.getGames())
    }.catch { error ->
        emit(value = Result.failure(exception = error))
    }.flowOn(Dispatchers.IO)
}