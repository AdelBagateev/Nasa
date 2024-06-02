package com.example.nasa.feature.about_space.presentation

data class AboutSpaceViewState(
    val cosmicBodies: List<CosmicBody> = emptyList()
)

data class CosmicBody(
    val title: String,
    val imageUrl: String
)

sealed class AboutSpaceAction {
    object NavigateToAsteroidList: AboutSpaceAction()
}

sealed class AboutSpaceEvent {
    data object OnSeeAllCosmicBodyClick : AboutSpaceEvent()
}
