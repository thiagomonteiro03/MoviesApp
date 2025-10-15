package com.montway.movies.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.montway.movies.ui.theme.MoviesAppTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun MovieGenreChip(
    genre: String,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier,
        shape = MaterialTheme.shapes.large,
        color = MaterialTheme.colorScheme.primary
    ) {
        Text(
            text = genre,
            modifier = Modifier
                .padding(horizontal = 8.dp),
            style = MaterialTheme.typography.labelSmall
        )
    }
}

@Preview
@Composable
private fun MovieGenreChipPreview() {
    MoviesAppTheme {
        MovieGenreChip(genre = "Action")
    }
}