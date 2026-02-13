package repository

import model.Game

interface SearchRepository {
    suspend fun search(query: String): Result<List<Game>>
}