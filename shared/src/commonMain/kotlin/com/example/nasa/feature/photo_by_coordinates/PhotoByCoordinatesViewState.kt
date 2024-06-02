package com.example.nasa.feature.photo_by_coordinates

data class PhotoByCoordinatesViewState(
    val satellitePhoto: SatellitePhoto? = null
)

data class SatellitePhoto(
    val imageUrl: String
)

sealed class PhotoByCoordinatesAction {
}

sealed class PhotoByCoordinatesEvent {
    data class GetPhoto(val lat: Int, val lon: Int) : PhotoByCoordinatesEvent()
}
