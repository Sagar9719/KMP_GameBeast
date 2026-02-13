package coreNetwork.apiService

import coreNetwork.model.game.GameResponse
import coreNetwork.model.gameDetails.GameDetailsResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class ApiService(
    val httpClient: HttpClient
) {
    suspend fun getGames(): Result<GameResponse> {
        return try {
            val response = httpClient.get(urlString = "api/games") {
                url {
                    parameter("key", "1abb1867f52548a4aa9f54dd4946af2f")
                }
            }.body<GameResponse>()
            Result.success(value = response)
        } catch (e: Exception) {
            Result.failure(exception = e)
        }
    }

    suspend fun searchGames(query: String): Result<GameResponse> {
        return try {
            val response = httpClient.get(urlString = "api/games") {
                url {
                    parameter("key", "1abb1867f52548a4aa9f54dd4946af2f")
                    parameter("search", query)
                }
            }.body<GameResponse>()
            Result.success(value = response)
        } catch (e: Exception) {
            Result.failure(exception = e)
        }
    }

    suspend fun getDetails(id: Int): Result<GameDetailsResponse> {
        return try {
            val response = httpClient.get(urlString = "api/games/${id}") {
                url {
                    parameter("key", "1abb1867f52548a4aa9f54dd4946af2f")
                }
            }.body<GameDetailsResponse>()
            Result.success(value = response)
        } catch (e: Exception) {
            Result.failure(exception = e)
        }
    }
}