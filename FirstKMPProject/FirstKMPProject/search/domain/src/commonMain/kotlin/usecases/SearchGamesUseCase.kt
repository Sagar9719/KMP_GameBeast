package usecases

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import repository.SearchRepository

class SearchGamesUseCase(
    private val searchRepository: SearchRepository
) {
    operator fun invoke(query: String) = flow {
        emit(value = searchRepository.search(query = query))
    }.catch { error ->
        emit(value = Result.failure(exception = error))
    }.flowOn(context = Dispatchers.IO)
}