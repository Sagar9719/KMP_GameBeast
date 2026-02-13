package game.domain.usecases

import game.domain.repository.GameRepository

class DeleteUseCase (private val gameRepository: GameRepository) {
    suspend operator fun invoke(id:Int) = gameRepository.delete(id)
}