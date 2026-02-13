package game.domain.repository

import game.domain.model.GameDetails
import model.Game

interface GameRepository {
    suspend fun getGames(): Result<List<Game>>
    suspend fun getDetails(id: Int): Result<GameDetails>
    suspend fun save(id: Int, image: String, name: String)
    suspend fun delete(id: Int)
}