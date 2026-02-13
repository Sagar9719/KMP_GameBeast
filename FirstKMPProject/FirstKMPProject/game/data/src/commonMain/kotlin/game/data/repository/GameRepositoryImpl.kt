package game.data.repository

import coreNetwork.apiService.ApiService
import game.data.mappers.toDomainGameDetails
import game.domain.model.GameDetails
import game.domain.repository.GameRepository
import mappers.toDomainListOfGames
import model.Game
import coreDatabase.AppDatabase

class GameRepositoryImpl(
    private val apiService: ApiService,
    private val appDatabase: AppDatabase
): GameRepository {
    override suspend fun getGames(): Result<List<Game>> {
        val result = apiService.getGames()
        return if(result.isSuccess) {
            Result.success(value = result.getOrThrow().results.toDomainListOfGames())
        } else{
            Result.failure(exception = result.exceptionOrNull()!!)
        }
    }

    override suspend fun getDetails(id: Int): Result<GameDetails> {
        val result = apiService.getDetails(id = id)
        return  if(result.isSuccess) {
            Result.success(value = result.getOrThrow().toDomainGameDetails())
        } else {
            Result.failure(exception = result.exceptionOrNull()!!)
        }
    }


    override suspend fun save(id: Int, image: String, name: String) {
        appDatabase.appDatabaseQueries
            .upsert(id.toLong(), image, name)
    }

    override suspend fun delete(id: Int) {
        appDatabase.appDatabaseQueries
            .delete(id.toLong())
    }
}
