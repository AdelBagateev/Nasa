package com.example.nasa.feature.asteroid_list

data class AsteroidListViewState(
    val asteroids: List<Asteroid> = emptyList()
)

data class Asteroid(
    val id: Int,
    val title: String,
    val imageUrl: String,
    val description: String
)

sealed class AsteroidListAction {
    class NavigateToDetails(val id: Int): AsteroidListAction()
    class NavigateToBack : AsteroidListAction()
}

sealed class AsteroidListEvent {
    data class OnAsteroidClick(val id: Int) : AsteroidListEvent()
    data object OnBackPressed : AsteroidListEvent()
}
