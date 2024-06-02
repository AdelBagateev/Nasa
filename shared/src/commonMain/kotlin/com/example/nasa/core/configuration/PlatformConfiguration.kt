package com.example.nasa.core.configuration

expect class PlatformConfiguration {
    val appVersionName: String
    val appVersionNumber: String
    val osVersion: String
    val deviceType: Configuration.DeviceType
}