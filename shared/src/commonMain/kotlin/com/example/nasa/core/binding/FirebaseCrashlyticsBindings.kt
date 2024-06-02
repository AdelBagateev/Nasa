package com.example.nasa.core.binding

interface FirebaseCrashlyticsBindings {

    fun nonFatal(error: Throwable)

    fun setParams(key: String, value: String)
}