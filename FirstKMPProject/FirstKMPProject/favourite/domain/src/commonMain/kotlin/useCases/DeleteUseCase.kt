package useCases

import repository.FavouriteRepository

class DeleteUseCase(private val favouriteRepository: FavouriteRepository) {
    suspend operator fun invoke(id: Int) = favouriteRepository.delete(id)
}