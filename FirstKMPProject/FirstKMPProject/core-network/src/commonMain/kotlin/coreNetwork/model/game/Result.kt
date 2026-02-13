package coreNetwork.model.game

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Result (
    @SerialName(value = "background_image")
    val backgroundImage: String? = null,
    @SerialName(value = "id")
    val id: Int,
    @SerialName(value = "name")
    val name: String
)