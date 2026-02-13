package game.ui.gameDetails.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import game.ui.gameDetails.viewmodels.GameDetailsViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun GameDetailsScreen(
    modifier: Modifier = Modifier,
    id: String,
    onBackClick: () -> Unit,
    viewModel: GameDetailsViewModel = koinViewModel< GameDetailsViewModel>()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(key1 = id) {
        viewModel.getGameDetails(id.toInt())
    }

    GameDetailsScreenContent(
        modifier = modifier.fillMaxSize(),
        uiState = uiState,
        onDelete = { gameId ->
            viewModel.delete(id = gameId)
        },
        onSave = { id, name, image ->
            viewModel.save(id = id, name = name, image = image)
        },
        onBackClick = onBackClick
    )
}


