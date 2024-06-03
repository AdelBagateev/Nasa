package com.example.nasa.di

import com.example.nasa.core.binding.FirebaseCrashlyticsBindings
import com.example.nasa.core.configuration.Configuration
import com.example.nasa.core.configuration.PlatformConfiguration
import com.example.nasa.core.network.networkModule
import com.example.nasa.feature.about_space.aboutSpaceModule
import com.example.nasa.feature.about_space.presentation.AboutSpaceViewModel
import org.kodein.di.DI
import org.kodein.di.DirectDI
import org.kodein.di.LazyDelegate
import org.kodein.di.bind
import org.kodein.di.bindSingleton
import org.kodein.di.direct
import org.kodein.di.instance
import org.kodein.di.singleton
import org.koin.core.component.KoinComponent
import org.koin.core.component.get

object PlatformSDK {

    private var _di: DirectDI? = null

    val di: DirectDI
        get() = requireNotNull(_di)

    fun init(conf: Configuration) {
        _di = DI {
            importAll(
                createConfigurationModule(conf),
                networkModule,
                aboutSpaceModule,
            )
        }.direct
    }

    inline fun <reified T : Any> lazyInstance(tag: Any? = null): LazyDelegate<T> {
        return di.lazy.instance(tag)
    }

    private fun createConfigurationModule(configuration: Configuration): DI.Module = DI.Module(
        name = "configurationModule",
        init = {
            bind<Configuration>() with singleton {
                configuration
            }
            bind<PlatformConfiguration>() with singleton { configuration.platformConfiguration }

            bindSingleton<FirebaseCrashlyticsBindings> {
                configuration.firebaseCrashlyticsBindings
            }
        },
    )
}

object ViewModels : KoinComponent {
    fun getAboutSpaceViewModel() = get<AboutSpaceViewModel>()
//    fun getNewsDetailsViewModel() = get<NewsDetailsViewModel>()
//
//    fun getReadLaterViewModel() = get<ReadLaterViewModel>()

}
