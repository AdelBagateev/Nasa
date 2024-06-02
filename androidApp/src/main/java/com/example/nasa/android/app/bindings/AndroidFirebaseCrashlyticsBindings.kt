package com.example.nasa.android.app.bindings

import com.example.nasa.core.binding.FirebaseCrashlyticsBindings
import com.google.firebase.crashlytics.FirebaseCrashlytics

class AndroidFirebaseCrashlyticsBindings : FirebaseCrashlyticsBindings {

    private val crashlytics by lazy {
        FirebaseCrashlytics.getInstance()
    }

    override fun nonFatal(error: Throwable) {
        crashlytics.recordException(error)
    }

    override fun setParams(key: String, value: String) {
        crashlytics.setCustomKey(key, value)
    }
}
