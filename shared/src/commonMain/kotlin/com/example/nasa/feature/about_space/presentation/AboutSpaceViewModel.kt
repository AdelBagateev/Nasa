package com.example.nasa.feature.about_space.presentation

import com.example.nasa.core.binding.FirebaseCrashlyticsBindings
import com.example.nasa.core.viewmodel.BaseViewModel
import com.example.nasa.feature.data.SpaceRepository
import com.example.nasa.di.PlatformSDK
import kotlinx.coroutines.launch

class AboutSpaceViewModel : BaseViewModel<AboutSpaceViewState, AboutSpaceAction, AboutSpaceEvent>(
    initState = AboutSpaceViewState()
) {

    private val repository: SpaceRepository by PlatformSDK.lazyInstance()
    private val crashlyticsBindings: FirebaseCrashlyticsBindings by PlatformSDK.lazyInstance()

    init {
        loadAboutSpaceInfo()
    }

    override fun obtainEvent(event: AboutSpaceEvent) {
        when (event) {
            AboutSpaceEvent.OnSeeAllCosmicBodyClick -> {
                viewAction = AboutSpaceAction.NavigateToAsteroidList
                viewAction = null
            }
        }
    }

    private fun loadAboutSpaceInfo() {
        scope.launch {
            try {
                val cosmicBodies = repository.getAboutSpaceScreenInfo()
                viewState { copy(cosmicBodies = cosmicBodies) }
            } catch (error: Throwable) {
                error.printStackTrace()
                crashlyticsBindings.nonFatal(error)
            }
        }
    }
}
