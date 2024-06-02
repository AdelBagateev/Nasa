package com.example.nasa.feature.asteroid_list

import android.widget.Toolbar
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.nasa.R
import com.example.nasa.feature.about_space.presentation.AboutSpaceEvent
import com.example.nasa.feature.about_space.presentation.AboutSpaceEvent.OnSeeAllCosmicBodyClick
import com.example.nasa.feature.about_space.presentation.AboutSpaceViewState
import com.example.nasa.feature.about_space.presentation.CosmicBody
import com.example.nasa.feature.asteroid_details.AsteroidDetailsEvent.OnBackPressed
import java.util.Locale

@Composable
internal fun AsteroidListView(
    viewState: AsteroidListViewState,
    consumer: (AsteroidListEvent) -> Unit,
) {
    Scaffold(
        topBar = {
            Header(consumer)
        },
        content = { padding ->
            LazyColumn(modifier = Modifier.padding(padding)) {
                items(viewState.asteroids.size) { index ->
                    AsteroidItem(viewState.asteroids[index], consumer)
                    Spacer(modifier = Modifier.height(28.dp))
                }
            }
        }
    )
}

@Composable
fun AsteroidItem(
    asteroid: Asteroid,
    consumer: (AsteroidListEvent) -> Unit
) {
    Row(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .clickable { consumer(AsteroidListEvent.OnAsteroidClick(asteroid.id)) }
            .background(Color.Gray, RoundedCornerShape(4))
        ,
    ) {
        AsyncImage(
            modifier = Modifier.size(height = 150.dp, width = 180.dp),
            model = asteroid.imageUrl,
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(20.dp))
        Column() {
            Text(text = asteroid.title, style = TextStyle(fontWeight = Bold))
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = asteroid.description)
        }
    }
}

@Composable
private fun Header(
    consumer: (AsteroidListEvent) -> Unit,
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            modifier = Modifier
                .size(40.dp)
                .clickable { consumer(AsteroidListEvent.OnBackPressed) }
            ,
            painter = painterResource(id = R.drawable.baseline_arrow_back_24),
            contentDescription = null,
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onBackground)
        )
        Text(
            modifier = Modifier
                .padding(vertical = 64.dp)
                .padding(start = 60.dp)
            ,
            text = "asteroids".uppercase(Locale.getDefault()),
            style = TextStyle(fontSize = 36.sp, letterSpacing = 2.sp)
        )
    }
}