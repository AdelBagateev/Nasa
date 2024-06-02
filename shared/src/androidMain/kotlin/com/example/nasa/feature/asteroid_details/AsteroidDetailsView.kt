package com.example.nasa.feature.asteroid_details

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.nasa.R
import com.example.nasa.feature.asteroid_details.AsteroidDetailsEvent.OnBackPressed

@Composable
internal fun AsteroidDetailsView(
    viewState: AsteroidDetailsViewState,
    consumer: (AsteroidDetailsEvent) -> Unit,
) {
    Scaffold(
        modifier = Modifier.padding(16.dp),
        topBar = {
            Header(consumer)
        },
        content = { padding ->
            viewState.asteroidDetails ?: return@Scaffold

            Column(modifier = Modifier.padding(padding)) {
                Text(text = viewState.asteroidDetails.name)
                AsyncImage(
                    model = viewState.asteroidDetails.imageUrl,
                    contentDescription = null
                )
                Text(
                    text = "id = ${viewState.asteroidDetails.id}"
                )
                Text(
                    text = "Description = ${viewState.asteroidDetails.description}"
                )
            }
        }
    )
}

@Composable
private fun Header(consumer: (AsteroidDetailsEvent) -> Unit) {
    Image(
        modifier = Modifier.size(60.dp)
            .clickable { consumer(OnBackPressed) }
        ,
        painter = painterResource(id = R.drawable.baseline_arrow_back_24),
        contentDescription = null,
        colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onBackground)
    )
}