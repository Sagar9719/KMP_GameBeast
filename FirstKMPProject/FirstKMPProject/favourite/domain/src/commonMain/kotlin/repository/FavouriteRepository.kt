package repository

import kotlinx.coroutines.flow.Flow
import model.Game

interface FavouriteRepository {
    fun getAllGames(): Flow<List<Game>>

    suspend fun upsert(id: Int, name: String, image: String)

    suspend fun delete(id: Int)
}