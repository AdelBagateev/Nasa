package com.example.nasa.feature.asteroid_list

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.nasa.DestinationScreen
import com.example.nasa.utils.rememberClick

@Composable
fun AsteroidListScreen(
    navController: NavHostController,
    viewModel: AsteroidListViewModel = viewModel()
) {
    val state by viewModel.viewStates.collectAsState()
    val action by viewModel.viewActions.collectAsState(initial = null)
    val consumer = rememberClick<AsteroidListEvent> { viewModel.obtainEvent(it) }

    AsteroidListView(
        viewState = state,
        consumer = consumer,
    )

    AsteroidListAction(navController = navController, action = action)
}

@Composable
private fun AsteroidListAction(
    navController: NavHostController,
    action: AsteroidListAction?
) {
    LaunchedEffect(action) {
        when (action) {
            is AsteroidListAction.NavigateToDetails -> {
                navController.navigate(
                    DestinationScreen.AsteroidDetailsScreen.withArgs(action.id.toString())
                )
            }
            is AsteroidListAction.NavigateToBack -> navController.popBackStack()
            null -> Unit
        }
    }
}
