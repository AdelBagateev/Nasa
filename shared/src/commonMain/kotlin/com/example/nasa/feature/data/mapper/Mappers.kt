package com.example.nasa.feature.data.mapper

import com.example.nasa.feature.asteroid_details.AsteroidDetails
import com.example.nasa.feature.data.model.AsteroidDetailsApi

fun AsteroidDetailsApi.toAsteroidDetails(): AsteroidDetails {
    return AsteroidDetails(
        id = id,
        name = name,
        imageUrl = imageUrl,
        description = description,
    )
}