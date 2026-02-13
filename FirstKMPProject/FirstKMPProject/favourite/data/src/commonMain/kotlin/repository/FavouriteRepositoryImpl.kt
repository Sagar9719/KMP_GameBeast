package repository

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import coreDatabase.AppDatabase
import model.Game
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class FavouriteRepositoryImpl(
    private val appDatabase: AppDatabase
): FavouriteRepository {
    override fun getAllGames(): Flow<List<Game>> {
        return appDatabase.appDatabaseQueries
            .getAllGames()
            .asFlow()
            .mapToList(context = Dispatchers.IO)
            .map {
                it.map { it ->
                    Game(
                        id = it.id.toInt(),
                        name = it.name,
                        imageUrl = it.image
                    )
                }
            }
    }

    override suspend fun upsert(id: Int, image: String, name: String) {
        appDatabase.appDatabaseQueries
            .upsert(id.toLong(), image, name)
    }

    override suspend fun delete(id: Int) {
        appDatabase.appDatabaseQueries
            .delete(id.toLong())
    }
}