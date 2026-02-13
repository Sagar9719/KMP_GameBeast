package game.ui.gameDetails.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import game.domain.model.Developer

@Composable
fun GameDetailsDeveloperScreen(
    developer: Developer
) {
    Surface(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 6.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(size = 16.dp),
        tonalElevation = 2.dp
    ) {
        Row(
            modifier = Modifier
                .padding(all = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            AsyncImage(
                model = developer.image,
                contentDescription = developer.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(size = 88.dp)
                    .clip(shape = RoundedCornerShape(size = 14.dp))
            )

            Spacer(Modifier.width(width = 16.dp))

            Column(
                modifier = Modifier.weight(weight = 1f)
            ) {
                Text(
                    text = developer.name,
                    style = MaterialTheme.typography.titleMedium
                )

                Spacer(Modifier.height(height = 6.dp))

                Text(
                    text = "Games: ${developer.gameCount}",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

