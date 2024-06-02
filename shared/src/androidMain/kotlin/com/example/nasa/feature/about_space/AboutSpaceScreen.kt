package com.example.nasa.feature.about_space

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.nasa.DestinationScreen
import com.example.nasa.feature.about_space.presentation.AboutSpaceAction
import com.example.nasa.feature.about_space.presentation.AboutSpaceEvent
import com.example.nasa.feature.about_space.presentation.AboutSpaceViewModel
import com.example.nasa.utils.rememberClick

@Composable
fun AboutSpaceScreen(
    navController: NavHostController,
    viewModel: AboutSpaceViewModel = viewModel()
) {
    val state by viewModel.viewStates.collectAsState()
    val action by viewModel.viewActions.collectAsState(initial = null)
    val consumer = rememberClick<AboutSpaceEvent> { viewModel.obtainEvent(it) }

    AboutSpaceView(
        viewState = state,
        consumer = consumer,
    )

    AboutSpaceAction(navController, action = action)
}

@Composable
private fun AboutSpaceAction(
    navController: NavHostController,
    action: AboutSpaceAction?
) {
    LaunchedEffect(action) {
        when (action) {
            AboutSpaceAction.NavigateToAsteroidList -> navController.navigate(
                DestinationScreen.AsteroidsListScreen.route
            )
            null -> Unit
        }
    }
}
