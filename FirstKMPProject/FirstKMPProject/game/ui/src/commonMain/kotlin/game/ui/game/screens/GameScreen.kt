package game.ui.game.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import game.ui.game.viewmodels.GameViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun GameScreen(
    modifier: Modifier = Modifier,
    viewModel: GameViewModel = koinViewModel<GameViewModel>(),
    onFavouriteClick: () -> Unit,
    onSearchClick: () -> Unit,
    onGameCardClick: (Int) -> Unit
) {
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(key1 = Unit) {
        viewModel.getGames()
    }

    GameScreenContent(
        modifier = modifier.fillMaxSize(),
        uiState = uiState.value,
        onFavouriteClick = onFavouriteClick,
        onSearchClick = onSearchClick,
        onGameCardClick = onGameCardClick
    )
}
