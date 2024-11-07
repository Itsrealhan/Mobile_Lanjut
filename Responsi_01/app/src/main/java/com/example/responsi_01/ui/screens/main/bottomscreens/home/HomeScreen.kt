package com.example.responsi_01.ui.screens.main.bottomscreens.home

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.responsi_01.R

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    val widgetGridViewItems = listOf(
        Song(
            id = 1,
            image = R.drawable.item_image,
            artist = "Artist 1",
            song = "Song 1"
        ),
        Song(
            id = 2,
            image = R.drawable.item_image,
            artist = "Artist 2",
            song = "Song 2"
        ),
        Song(
            id = 3,
            image = R.drawable.item_image,
            artist = "Artist 3",
            song = "Song 3"
        ),
        Song(
            id = 4,
            image = R.drawable.item_image,
            artist = "Artist 4",
            song = "Song 4"
        ),
        Song(
            id = 5,
            image = R.drawable.item_image,
            artist = "Artist 5",
            song = "Song 5"
        ),
    )

    val widgetListViewItems = listOf(
        Video(
            id = 1,
            image = R.drawable.item_image,
            headline = "Headline 1",
            description = "Description duis aute irure dolor in reprehenderit in voluptate velit.",
            uploadTime = "Today",
            durationInMinute = 23
        ),
        Video(
            id = 2,
            image = R.drawable.item_image,
            headline = "Headline 2",
            description = "Description duis aute irure dolor in reprehenderit in voluptate velit.",
            uploadTime = "Today",
            durationInMinute = 23
        ),
        Video(
            id = 3,
            image = R.drawable.item_image,
            headline = "Headline 3",
            description = "Description duis aute irure dolor in reprehenderit in voluptate velit.",
            uploadTime = "Today",
            durationInMinute = 23
        ),
        Video(
            id = 4,
            image = R.drawable.item_image,
            headline = "Headline 4",
            description = "Description duis aute irure dolor in reprehenderit in voluptate velit.",
            uploadTime = "Today",
            durationInMinute = 23
        ),
        Video(
            id = 5,
            image = R.drawable.item_image,
            headline = "Headline 5",
            description = "Description duis aute irure dolor in reprehenderit in voluptate velit.",
            uploadTime = "Today",
            durationInMinute = 23
        ),
    )

    Surface(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    start = 4.dp,
                    top = 20.dp,
                    end = 4.dp,
                )
        ) {
            TopBar(
                username = "Guest",
                onUserImageClick = { /*TODO*/ },
                onNotificationClick = { /*TODO*/ },
                onSettingClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp)
            )
            WidgetGridView(
                title = "Widget Grid View",
                items = widgetGridViewItems,
                onMoreClick = { /*TODO*/ },
                onItemClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 16.dp,
                        end = 16.dp,
                        bottom = 16.dp
                    )
            )
            WidgetListView(
                title = "Widget List View",
                items = widgetListViewItems,
                onMoreClick = { /*TODO*/ },
                onItemClick = { /*TODO*/ },
                onAddClick = { /*TODO*/ },
                onPlayClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 16.dp,
                        end = 16.dp
                    )
            )
        }
    }
}

@Composable
private fun TopBar(
    username: String,
    onUserImageClick: () -> Unit,
    onNotificationClick: () -> Unit,
    onSettingClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 4.dp)
        ) {
            IconButton(onClick = onUserImageClick) {
                Icon(
                    painter = painterResource(id = R.drawable.account_circle_filled_24px),
                    contentDescription = stringResource(R.string.foto_profil_anda),
                    modifier = Modifier.size(size = 32.dp)
                )
            }
            Row {
                IconButton(
                    onClick = onNotificationClick,
                    modifier = Modifier
                        .padding(end = 4.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.notifications_24px),
                        contentDescription = stringResource(R.string.notifikasi)
                    )
                }
                IconButton(onClick = onSettingClick) {
                    Icon(
                        painter = painterResource(id = R.drawable.settings_24px),
                        contentDescription = stringResource(R.string.pengaturan)
                    )
                }
            }
        }
        Text(
            text = username,
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(start = 16.dp)
        )
    }
}

@Composable
private fun WidgetGridView(
    title: String,
    items: List<Song>,
    onMoreClick: () -> Unit,
    onItemClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge
            )
            IconButton(onClick = onMoreClick) {
                Icon(
                    painter = painterResource(id = R.drawable.arrow_forward_24px),
                    contentDescription = stringResource(R.string.lihat_lebih_banyak)
                )
            }
        }
        LazyRow {
            itemsIndexed(items = items) { index, item ->
                val itemEndPaddingValue = if (index != items.lastIndex) {
                    12.dp
                } else { 0.dp }

                Card(
                    onClick = { onItemClick(item.id) },
                    modifier = Modifier
                        .padding(end = itemEndPaddingValue)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(
                                vertical = 12.dp,
                                horizontal = 12.dp
                            )
                    ) {
                        Image(
                            painter = painterResource(id = item.image), 
                            contentDescription = null,
                            modifier = Modifier
                                .size(size = 112.dp)
                        )
                        Text(
                            text = item.artist,
                            style = MaterialTheme.typography.titleSmall,
                            fontWeight = FontWeight.SemiBold,
                            maxLines = 1,
                            modifier = Modifier
                                .padding(
                                    top = 8.dp,
                                    bottom = 4.dp
                                )
                        )
                        Text(
                            text = item.song,
                            style = MaterialTheme.typography.bodySmall,
                            maxLines = 1
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun WidgetListView(
    title: String,
    items: List<Video>,
    onMoreClick: () -> Unit,
    onItemClick: (Int) -> Unit,
    onAddClick: (Int) -> Unit,
    onPlayClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge
            )
            IconButton(onClick = onMoreClick) {
                Icon(
                    painter = painterResource(id = R.drawable.arrow_forward_24px),
                    contentDescription = stringResource(R.string.lihat_lebih_banyak)
                )
            }
        }
        LazyColumn {
            itemsIndexed(items = items) { index, item ->
                val itemBottomPaddingValue = if (index != items.lastIndex) {
                    12.dp
                } else { 0.dp }

                Card(
                    onClick = { onItemClick(item.id) },
                    modifier = Modifier
                        .padding(bottom = itemBottomPaddingValue)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(height = 120.dp)
                            .padding(
                                vertical = 12.dp,
                                horizontal = 12.dp
                            )
                    ) {
                        Image(
                            painter = painterResource(id = item.image),
                            contentDescription = null,
                            modifier = Modifier
                                .size(size = 116.dp)
                        )
                        Column(
                            verticalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .fillMaxHeight()
                                .padding(start = 12.dp)
                        ) {
                            Column {
                                Text(
                                    text = item.headline,
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.SemiBold,
                                    maxLines = 1,
                                    modifier = Modifier
                                        .padding(bottom = 4.dp)
                                )
                                Text(
                                    text = item.description,
                                    style = MaterialTheme.typography.bodySmall,
                                    maxLines = 2,
                                    modifier = Modifier
                                        .padding(bottom = 12.dp)
                                )
                            }
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.add_circle_24px),
                                        contentDescription = stringResource(
                                            R.string.tambah_video_ke_daftar_putar,
                                            item.headline
                                        ),
                                        modifier = Modifier
                                            .clickable { onAddClick(item.id) }
                                    )
                                    Text(
                                        text = item.uploadTime,
                                        style = MaterialTheme.typography.bodySmall,
                                        maxLines = 1,
                                        modifier = Modifier
                                            .padding(start = 4.dp)
                                    )
                                    Text(
                                        text = stringResource(
                                            R.string.min,
                                            item.durationInMinute
                                        ),
                                        style = MaterialTheme.typography.bodySmall,
                                        maxLines = 1
                                    )
                                }
                                Icon(
                                    painter = painterResource(id = R.drawable.play_arrow_filled_24px),
                                    contentDescription = stringResource(
                                        R.string.putar_video,
                                        item.headline
                                    ),
                                    modifier = Modifier
                                        .clickable { onPlayClick(item.id) }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

data class Song(
    val id: Int,
    @DrawableRes val image: Int,
    val artist: String,
    val song: String
)

data class Video(
    val id: Int,
    @DrawableRes val image: Int,
    val headline: String,
    val description: String,
    val uploadTime: String,
    val durationInMinute: Int
)