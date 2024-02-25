package com.example.nasa

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform