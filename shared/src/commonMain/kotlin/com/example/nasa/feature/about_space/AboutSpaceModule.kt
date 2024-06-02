package com.example.nasa.feature.about_space

import com.example.nasa.feature.data.SpaceRepository
import org.kodein.di.DI
import org.kodein.di.bindProvider
import org.kodein.di.instance

val aboutSpaceModule = DI.Module("aboutSpaceModule") {
    bindProvider<SpaceRepository> {
        SpaceRepository(instance())
    }
}
