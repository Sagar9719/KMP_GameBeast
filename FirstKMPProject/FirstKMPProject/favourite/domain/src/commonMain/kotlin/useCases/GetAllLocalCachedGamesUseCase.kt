package useCases

import repository.FavouriteRepository

class GetAllLocalCachedGamesUseCase(
    private val favouriteRepository: FavouriteRepository
) {
    operator fun invoke() = favouriteRepository.getAllGames()
}