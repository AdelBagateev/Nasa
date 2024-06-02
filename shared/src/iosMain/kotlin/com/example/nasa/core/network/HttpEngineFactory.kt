package com.example.nasa.core.network

import com.example.nasa.core.configuration.PlatformConfiguration
import io.ktor.client.engine.HttpClientEngineConfig
import io.ktor.client.engine.HttpClientEngineFactory
import io.ktor.client.engine.darwin.Darwin

actual open class HttpEngineFactory actual constructor() {

    actual fun createEngine(
        platformConfiguration: PlatformConfiguration,
    ): HttpClientEngineFactory<HttpClientEngineConfig> = Darwin
}