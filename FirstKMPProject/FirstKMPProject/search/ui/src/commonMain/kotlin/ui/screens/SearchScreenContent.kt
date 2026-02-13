package ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import org.jetbrains.compose.ui.tooling.preview.Preview
import ui.viewmodels.SearchViewModel

@Composable
fun SearchScreenContent(
    modifier: Modifier = Modifier,
    uiState: SearchViewModel.UiState,
    query: String,
    onQueryChange: (String) -> Unit,
    onClick: (Int) -> Unit,
    onBackClick: () -> Unit
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            SearchTopBar(
                query = query,
                onQueryChange = onQueryChange,
                onBackClick = onBackClick
            )
        }
    ) { innerPadding ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = innerPadding)
        ) {

            when {
                uiState.isLoading -> {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center)
                    )
                }

                !uiState.error.isNullOrBlank() -> {
                    Text(
                        text = uiState.error,
                        modifier = Modifier.align(Alignment.Center),
                        color = MaterialTheme.colorScheme.error
                    )
                }

                else -> {
                    SearchGrid(
                        data = uiState.data,
                        onClick = onClick
                    )
                }
            }
        }
    }
}

@Composable
@Preview
fun SearchScreenContentPreview() {
    SearchScreenContent(
        modifier = Modifier,
        uiState = SearchViewModel.UiState(),
        query = "",
        onQueryChange = {},
        onClick = {},
        onBackClick = {})
}