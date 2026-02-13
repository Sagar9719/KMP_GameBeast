package game.ui.gameDetails.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import game.ui.gameDetails.viewmodels.GameDetailsViewModel

@Composable
fun GameDetailsScreenContent(
    modifier: Modifier,
    uiState: GameDetailsViewModel.UiState,
    onDelete: (Int) -> Unit,
    onSave: (id: Int, title: String, image: String) -> Unit,
    onBackClick: () -> Unit
) {
    Scaffold(
        modifier = modifier.fillMaxSize()
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

                uiState.error.isNotBlank() -> {
                    Text(
                        text = uiState.error,
                        modifier = Modifier.align(Alignment.Center),
                        color = MaterialTheme.colorScheme.error
                    )
                }

                else -> {
                    uiState.data?.let { data ->
                        Box(modifier = modifier.fillMaxSize()) {
                            LazyColumn {

                                item {
                                    GameDetailsHeader(
                                        image = data.backgroundImage,
                                        title = data.name,
                                        onBack = onBackClick,
                                        onSave = {
                                            onSave(
                                                data.id,
                                                data.name,
                                                data.backgroundImage
                                            )
                                        },
                                        onDelete = { onDelete(data.id) }
                                    )
                                }

                                item {
                                    ExpandableDescription(text = data.description)
                                }

                                item {
                                    SectionTitle(text = "Platforms")
                                }

                                item {
                                    LazyRow(contentPadding = PaddingValues(horizontal = 16.dp)) {
                                        items(items = data.platforms) {
                                            PlatformCard(name = it.name, image = it.image)
                                            Spacer(Modifier.width(width = 12.dp))
                                        }
                                    }
                                }

                                item {
                                    SectionTitle(text = "Stores")
                                }

                                items(items = data.stores) { storeData ->
                                    GameDetailStoreScreen(storeData)
                                }

                                item { SectionTitle(text = "Tags") }

                                item {
                                    FlowRow(
                                        modifier = Modifier.padding(horizontal = 16.dp),
                                        horizontalArrangement = Arrangement.spacedBy(space = 8.dp),
                                        verticalArrangement = Arrangement.spacedBy(space = 8.dp)
                                    ) {
                                        data.tags.forEach {
                                            TagChip(name = it.name, image = it.image)
                                        }
                                    }
                                }

                                item {
                                    SectionTitle(text = "Developers")
                                }

                                items(items = data.developers) { storeData ->
                                    GameDetailsDeveloperScreen(storeData)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}