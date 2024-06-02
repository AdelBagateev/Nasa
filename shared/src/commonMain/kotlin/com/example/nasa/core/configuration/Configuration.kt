package com.example.nasa.core.configuration

import com.example.nasa.core.binding.FirebaseCrashlyticsBindings

data class Configuration(
    val platformConfiguration: PlatformConfiguration,
    val isHttpLoggingEnabled: Boolean,
    val isDebug: Boolean,

    val firebaseCrashlyticsBindings: FirebaseCrashlyticsBindings,
) {

    enum class DeviceType {
        Tablet,
        Phone,
    }
}
