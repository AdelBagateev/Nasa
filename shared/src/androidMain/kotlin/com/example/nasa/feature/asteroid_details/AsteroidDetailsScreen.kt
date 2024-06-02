package com.example.nasa.feature.asteroid_details

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.nasa.feature.asteroid_list.AsteroidListAction
import com.example.nasa.utils.rememberClick

@Composable
fun AsteroidDetailsScreen(
    id: Int,
    navController: NavHostController,
    viewModel: AsteroidDetailsViewModel = viewModel()
) {
    val state by viewModel.viewStates.collectAsState()
    val action by viewModel.viewActions.collectAsState(initial = null)
    val consumer = rememberClick<AsteroidDetailsEvent> { viewModel.obtainEvent(it) }

    AsteroidDetailsView(
        viewState = state,
        consumer = consumer,
    )

    AsteroidDetailsAction(
        id = id,
        consumer = consumer,
        navController = navController,
        action = action
    )
}

@Composable
private fun AsteroidDetailsAction(
    id: Int,
    consumer: (AsteroidDetailsEvent) -> Unit,
    navController: NavHostController,
    action: AsteroidDetailsAction?,
) {
    LaunchedEffect(action) {
        when (action) {
            is AsteroidDetailsAction.NavigateToBack -> navController.popBackStack()
            null -> Unit
        }
        consumer(AsteroidDetailsEvent.InitAction(id))
    }
}
