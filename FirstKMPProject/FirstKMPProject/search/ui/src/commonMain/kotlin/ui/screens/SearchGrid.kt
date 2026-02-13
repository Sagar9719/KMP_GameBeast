package ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import model.Game
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun SearchGrid(
    data: List<Game>,
    onClick: (Int) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(count = 2),
        contentPadding = PaddingValues(all = 12.dp),
        verticalArrangement = Arrangement.spacedBy(space = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(space = 12.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        items(items = data,key = { it.id }) { item ->
            SearchGridItem(game = item, onClick = onClick)
        }
    }
}

@Composable
@Preview
fun SearchGridPreview() {
    SearchGrid(data = emptyList(), onClick = {})
}