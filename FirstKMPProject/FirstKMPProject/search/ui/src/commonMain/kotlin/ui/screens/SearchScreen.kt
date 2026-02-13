package ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.compose.viewmodel.koinViewModel
import ui.viewmodels.SearchViewModel

@Composable
fun SearchScreen(
    modifier: Modifier,
    viewModel: SearchViewModel = koinViewModel<SearchViewModel>(),
    onClick: (Int) -> Unit,
    onBackClick:()-> Unit
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val query = rememberSaveable { mutableStateOf(value = "") }

    SearchScreenContent(
        modifier = modifier.fillMaxSize(),
        uiState = uiState,
        query = query.value,
        onQueryChange = {
            query.value = it
            viewModel.onSearch(query = query.value)
        },
        onClick = onClick,
        onBackClick = onBackClick
    )
}
