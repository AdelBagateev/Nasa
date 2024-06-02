package com.example.nasa.feature.asteroid_details

import com.example.nasa.feature.asteroid_list.AsteroidListAction

data class AsteroidDetailsViewState(
    val asteroidDetails: AsteroidDetails? = null
)

data class AsteroidDetails(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val description: String
)

sealed class AsteroidDetailsAction {
    data object NavigateToBack : AsteroidDetailsAction()
}

sealed class AsteroidDetailsEvent {
    data object OnBackPressed : AsteroidDetailsEvent()
    data class InitAction(val id: Int) : AsteroidDetailsEvent()
}
