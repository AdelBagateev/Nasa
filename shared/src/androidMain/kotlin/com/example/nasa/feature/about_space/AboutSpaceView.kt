package com.example.nasa.feature.about_space

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.nasa.R
import com.example.nasa.feature.about_space.presentation.AboutSpaceEvent
import com.example.nasa.feature.about_space.presentation.AboutSpaceEvent.OnSeeAllCosmicBodyClick
import com.example.nasa.feature.about_space.presentation.AboutSpaceViewState
import com.example.nasa.feature.about_space.presentation.CosmicBody
import java.util.Locale

@Composable
internal fun AboutSpaceView(
    viewState: AboutSpaceViewState,
    consumer: (AboutSpaceEvent) -> Unit,
) {
    Scaffold(
        topBar = {
            Header()
        },
        content = { padding ->
            LazyColumn(modifier = Modifier.padding(padding)) {
                items(viewState.cosmicBodies.size) { index ->
                    CosmicBodyItem(viewState.cosmicBodies[index], consumer)
                    Spacer(modifier = Modifier.height(28.dp))
                }
            }
        },
        bottomBar = {
            Row(horizontalArrangement = Arrangement.SpaceAround) {


            }
        }
    )
}

@Composable
fun CosmicBodyItem(
    cosmicBody: CosmicBody,
    consumer: (AboutSpaceEvent) -> Unit
) {
    Box() {

        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .background(Color.Gray, RoundedCornerShape(4))
            ,
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            Row() {
                Text(text = cosmicBody.title)
                Spacer(modifier = Modifier.weight(1f))
                Row(
                    modifier = Modifier
                        .clickable { consumer(OnSeeAllCosmicBodyClick) },
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                )
                {
                    Text(text = "See all")
                    Image(
                        modifier = Modifier.size(20.dp),
                        painter = painterResource(id = R.drawable.row_forward_24),
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onBackground)
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            AsyncImage(
                model = cosmicBody.imageUrl,
                contentDescription = null
            )
            Spacer(modifier = Modifier.height(20.dp))

        }
    }
}

@Composable
private fun Header() {
    Text(
        modifier = Modifier
            .padding(vertical = 64.dp)
            .padding(start = 60.dp)
        ,
        text = "about space".uppercase(Locale.getDefault()),
        style = TextStyle(fontSize = 36.sp, letterSpacing = 2.sp)
    )
}


@Preview(showBackground = true)
@Composable
private fun SearchView_Preview() {
    AboutSpaceView(
        viewState = AboutSpaceViewState(emptyList()),
        consumer = { }
    )
}