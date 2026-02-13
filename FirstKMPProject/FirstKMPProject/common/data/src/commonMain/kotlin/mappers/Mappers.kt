package mappers

import model.Game
import coreNetwork.model.game.Result

fun List<Result>.toDomainListOfGames(): List<Game> = map { game ->
    Game(
        id = game.id,
        name = game.name,
        imageUrl = game.backgroundImage
    )
}