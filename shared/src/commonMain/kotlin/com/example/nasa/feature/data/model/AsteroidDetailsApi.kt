package com.example.nasa.feature.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class AsteroidDetailsResponse(
    @SerialName("near_earth_objects") val nearEarthObjects: Map<String, AsteroidDetailsApi>
)

@Serializable
class AsteroidDetailsApi(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    val imageUrl: String = "https://fb.ru/misc/i/gallery/39319/2294215.jpg",
    @SerialName("designation")
    val description: String
)