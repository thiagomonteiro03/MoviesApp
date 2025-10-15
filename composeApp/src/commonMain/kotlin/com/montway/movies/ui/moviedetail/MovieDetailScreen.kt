package com.montway.movies.ui.moviedetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.montway.movies.domain.model.Movie
import com.montway.movies.domain.model.movie1
import com.montway.movies.ui.components.CastMemberItem
import com.montway.movies.ui.components.MovieGenreChip
import com.montway.movies.ui.components.MovieInfoItem
import com.montway.movies.ui.theme.MoviesAppTheme
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.solid.ArrowLeft
import compose.icons.fontawesomeicons.solid.Calendar
import compose.icons.fontawesomeicons.solid.Clock
import compose.icons.fontawesomeicons.solid.Play
import compose.icons.fontawesomeicons.solid.Star
import movies.composeapp.generated.resources.Res
import movies.composeapp.generated.resources.minecraft_movie
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun MovieDetailRoute() {
    MovieDetailScreen(movie = movie1)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieDetailScreen(movie: Movie) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "Movie Detail")
                },
                navigationIcon = {
                    Surface(
                        modifier = Modifier.padding(start = 12.dp),
                        shape = MaterialTheme.shapes.small
                    ) {
                        IconButton(
                            onClick = {

                            },
                            modifier = Modifier
                                .size(32.dp)
                        ) {
                            Icon(
                                imageVector = FontAwesomeIcons.Solid.ArrowLeft,
                                contentDescription = null,
                                modifier = Modifier.padding(8.dp)
                            )
                        }
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background,
                )
            )
        },
    ) { paddingValues ->
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .weight(1f),
                shape = MaterialTheme.shapes.large
            ) {
                Image(
                    painter = painterResource(Res.drawable.minecraft_movie),
                    contentDescription = null,
                    modifier = Modifier
                        .clip(MaterialTheme.shapes.large),
                    contentScale = ContentScale.Crop,
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(2f)
                    .padding(top = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = movie.title,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleLarge
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    MovieInfoItem(
                        icon = FontAwesomeIcons.Solid.Star,
                        text = "7.5"
                    )

                    Spacer(modifier = Modifier.width(16.dp))

                    MovieInfoItem(
                        icon = FontAwesomeIcons.Solid.Clock,
                        text = "2h 36min"
                    )

                    Spacer(modifier = Modifier.width(16.dp))

                    MovieInfoItem(
                        icon = FontAwesomeIcons.Solid.Calendar,
                        text = "2022"
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    MovieGenreChip(
                        genre = "Action",
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    ElevatedButton(
                        onClick = {

                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                    ) {
                        Icon(
                            imageVector = FontAwesomeIcons.Solid.Play,
                            contentDescription = null,
                            modifier = Modifier
                                .size(12.dp)
                        )
                        Text(
                            text = "Watch trailer",
                            modifier = Modifier
                                .padding(start = 16.dp),
                            fontWeight = FontWeight.Medium,
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                BoxWithConstraints(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    val itemWidth = maxWidth * 0.55f

                    LazyRow(
                        contentPadding = PaddingValues(horizontal = 16.dp),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        items(10) {
                            CastMemberItem(
                                profilePictureUrl = "",
                                name = "Will Smith",
                                character = "John Smith",
                                modifier = Modifier
                                    .width(itemWidth)
                            )
                        }
                    }
                }

                Box(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "Trying to leave their troubled lives behind, twin brothers return to their hometown to start again, only to discover that an even greater evil is waiting to welcome them back.",
                        style = MaterialTheme.typography.bodySmall,
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun MovieDetailPreview() {
    MoviesAppTheme {
        MovieDetailScreen(
            movie = movie1
        )
    }
}