package game.domain.usecases

import game.domain.model.GameDetails
import game.domain.repository.GameRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GetGameDetailsUseCase(
    private val gameRepository: GameRepository
) {
    operator fun invoke(id: Int) = flow<Result<GameDetails>> {
        emit(value = gameRepository.getDetails(id = id))
    }.catch { error ->
        emit(value = Result.failure(exception = error))
    }.flowOn(context = Dispatchers.IO)
}