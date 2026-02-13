package game.domain.model

data class GameDetails(
    val name: String,
    val id: Int,
    val description: String,
    val backgroundImage: String,
    val additionalImage: String?,
    val platforms: List<Platform>,
    val stores: List<Stores>,
    val developers: List<Developer>,
    val tags: List<Tag>
)