package com.example.nasa.android.app

import android.os.Build
import com.example.nasa.android.app.bindings.AndroidFirebaseCrashlyticsBindings
import com.example.nasa.core.configuration.Configuration
import com.example.nasa.core.configuration.PlatformConfiguration
import com.example.nasa.di.PlatformSDK
import com.example.nasa.utils.deviceType
import com.google.android.datatransport.BuildConfig

fun AppDelegate.initShared() {
    val config = Configuration(
        platformConfiguration = PlatformConfiguration(
            androidContext = applicationContext,
            appVersionName = BuildConfig.VERSION_NAME,
            appVersionNumber = BuildConfig.VERSION_CODE.toString(),
            osVersion = Build.VERSION.RELEASE.toString(),
            deviceType = resources.deviceType
        ),
        isDebug = BuildConfig.DEBUG,
        isHttpLoggingEnabled = BuildConfig.DEBUG,

        firebaseCrashlyticsBindings = AndroidFirebaseCrashlyticsBindings()
    )
    PlatformSDK.init(conf = config)
}