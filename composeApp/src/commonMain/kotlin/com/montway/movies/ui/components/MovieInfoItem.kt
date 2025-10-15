package com.montway.movies.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.solid.Star
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun MovieInfoItem(
    icon: ImageVector,
    text: String,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(10.dp),
            tint = Color.Gray
        )

        Text(
            text = text,
            modifier = Modifier
                .padding(start = 2.dp),
            color = Color.Gray,
            style = MaterialTheme.typography.bodySmall
        )
    }
}

@Preview
@Composable
private fun MovieInfoItemPreview() {
    MovieInfoItem(
        icon = FontAwesomeIcons.Solid.Star,
        text = "8.5",
    )
}