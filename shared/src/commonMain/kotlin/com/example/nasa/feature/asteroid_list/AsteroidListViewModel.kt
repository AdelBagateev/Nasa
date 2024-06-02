package com.example.nasa.feature.asteroid_list

import com.example.nasa.core.binding.FirebaseCrashlyticsBindings
import com.example.nasa.core.viewmodel.BaseViewModel
import com.example.nasa.feature.data.SpaceRepository
import com.example.nasa.di.PlatformSDK
import com.example.nasa.feature.about_space.presentation.AboutSpaceAction
import kotlinx.coroutines.launch

class AsteroidListViewModel : BaseViewModel<AsteroidListViewState, AsteroidListAction, AsteroidListEvent>(
    initState = AsteroidListViewState()
) {

    private val repository: SpaceRepository by PlatformSDK.lazyInstance()
    private val crashlyticsBindings: FirebaseCrashlyticsBindings by PlatformSDK.lazyInstance()

    init {
        loadAsteroidList()
    }

    override fun obtainEvent(event: AsteroidListEvent) {
        when (event) {
            is AsteroidListEvent.OnAsteroidClick -> {
                viewAction = AsteroidListAction.NavigateToDetails(event.id)
                viewAction = null
            }
            AsteroidListEvent.OnBackPressed -> {
                viewAction = AsteroidListAction.NavigateToBack()
                viewAction = null
            }
        }
    }

    private fun loadAsteroidList() {
        scope.launch {
            try {
                val asteroids = repository.getAsteroidsList()
                viewState { copy(asteroids = asteroids) }
            } catch (error: Throwable) {
                error.printStackTrace()
                crashlyticsBindings.nonFatal(error)
            }
        }
    }
}
