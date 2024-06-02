package com.example.nasa.feature.photo_by_coordinates

import com.example.nasa.core.binding.FirebaseCrashlyticsBindings
import com.example.nasa.core.viewmodel.BaseViewModel
import com.example.nasa.feature.data.SpaceRepository
import com.example.nasa.di.PlatformSDK
import kotlinx.coroutines.launch

class PhotoByCoordinatesViewModel : BaseViewModel<PhotoByCoordinatesViewState, PhotoByCoordinatesAction, PhotoByCoordinatesEvent>(
    initState = PhotoByCoordinatesViewState()
) {

    private val repository: SpaceRepository by PlatformSDK.lazyInstance()
    private val crashlyticsBindings: FirebaseCrashlyticsBindings by PlatformSDK.lazyInstance()

    override fun obtainEvent(event: PhotoByCoordinatesEvent) {
        when (event) {
            is PhotoByCoordinatesEvent.GetPhoto -> loadPhotoByCoordinates(event.lat, event.lon)
        }
    }

    private fun loadPhotoByCoordinates(
        lat: Int,
        lon: Int
    ) {
        scope.launch {
            try {
                val photoUrl = repository.getPhotoByLanAndLon(lat, lon)
                viewState { copy( satellitePhoto = SatellitePhoto(photoUrl)) }
            } catch (error: Throwable) {
                error.printStackTrace()
//                crashlyticsBindings.nonFatal(error)
            }
        }
    }
}
