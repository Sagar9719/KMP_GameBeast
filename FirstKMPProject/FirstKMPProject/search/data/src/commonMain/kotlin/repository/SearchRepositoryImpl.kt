package repository

import coreNetwork.apiService.ApiService
import mappers.toDomainListOfGames
import model.Game

class SearchRepositoryImpl(
    private val apiService: ApiService
): SearchRepository {
    override suspend fun search(query: String): Result<List<Game>> {
        return try {
            val response = apiService.searchGames(query = query)
            val data = response.getOrThrow().results.toDomainListOfGames()
            Result.success(value = data)
        } catch (e: Exception) {
            Result.failure(exception = e)
        }
    }
}