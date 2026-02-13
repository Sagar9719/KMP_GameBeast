package coreNetwork.client

import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.accept
import io.ktor.http.ContentType
import io.ktor.http.URLProtocol
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

object KtorClient {
    fun getInstance(): HttpClient = HttpClient {

        install(plugin = ContentNegotiation) {
            json(json = Json {
                ignoreUnknownKeys = true
            })
        }

        install(plugin = DefaultRequest) {
            url {
                host = "api.rawg.io"
                protocol = URLProtocol.HTTPS
                contentType(type = ContentType.Application.Json)
                accept(ContentType.Application.Json)
            }
        }

        install(plugin = HttpTimeout) {
            socketTimeoutMillis = 3000
            connectTimeoutMillis = 3000
            requestTimeoutMillis = 3000
        }
    }
}