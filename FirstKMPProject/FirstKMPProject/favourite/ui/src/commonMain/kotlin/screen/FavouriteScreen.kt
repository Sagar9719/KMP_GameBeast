package screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.compose.viewmodel.koinViewModel
import viewmodels.FavouriteViewModel

@Composable
fun FavoriteScreen(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    onDetails: (Int) -> Unit
) {
    val viewModel = koinViewModel<FavouriteViewModel>()
    val games = viewModel.games.collectAsStateWithLifecycle()

    FavoriteScreenContent(
        modifier = modifier,
        games = games.value,
        onBackClick = onBackClick,
        onDetails = onDetails,
        onDelete = viewModel::delete
    )
}


