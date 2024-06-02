package com.example.nasa.core.network

import com.example.nasa.core.configuration.PlatformConfiguration
import io.ktor.client.engine.*

expect open class HttpEngineFactory() {

    fun createEngine(platformConfiguration: PlatformConfiguration): HttpClientEngineFactory<HttpClientEngineConfig>
}