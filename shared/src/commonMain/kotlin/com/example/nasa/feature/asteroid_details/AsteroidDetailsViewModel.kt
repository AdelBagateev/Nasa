package com.example.nasa.feature.asteroid_details

import com.example.nasa.core.binding.FirebaseCrashlyticsBindings
import com.example.nasa.core.viewmodel.BaseViewModel
import com.example.nasa.di.PlatformSDK
import com.example.nasa.feature.data.SpaceRepository
import kotlinx.coroutines.launch

class AsteroidDetailsViewModel :
    BaseViewModel<AsteroidDetailsViewState, AsteroidDetailsAction, AsteroidDetailsEvent>(
        initState = AsteroidDetailsViewState()
    ) {

    private val repository: SpaceRepository by PlatformSDK.lazyInstance()
    private val crashlyticsBindings: FirebaseCrashlyticsBindings by PlatformSDK.lazyInstance()

    override fun obtainEvent(event: AsteroidDetailsEvent) {
        when (event) {

            AsteroidDetailsEvent.OnBackPressed -> {
                viewAction = AsteroidDetailsAction.NavigateToBack
                viewAction = null
            }
            is AsteroidDetailsEvent.InitAction -> loadAsteroidDetails(event.id)
        }
    }

    private fun loadAsteroidDetails(id: Int) {
        scope.launch {
            try {
                val asteroidDetails = repository.getAsteroidDetailsById(id)
                viewState { copy(asteroidDetails = asteroidDetails) }
            } catch (error: Throwable) {
                error.printStackTrace()
//                crashlyticsBindings.nonFatal(error)
            }
        }
    }
}
