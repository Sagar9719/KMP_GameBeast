package useCases

import repository.FavouriteRepository

class UpsertUseCase(private val favouriteRepository: FavouriteRepository) {

    suspend operator fun invoke(id: Int, image: String, name: String) =
        favouriteRepository.upsert(id, image = image, name = name)
}