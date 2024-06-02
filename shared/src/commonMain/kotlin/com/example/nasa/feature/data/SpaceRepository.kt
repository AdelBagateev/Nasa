package com.example.nasa.feature.data

import com.example.nasa.feature.about_space.presentation.CosmicBody
import com.example.nasa.feature.asteroid_details.AsteroidDetails
import com.example.nasa.feature.asteroid_list.Asteroid
import com.example.nasa.feature.data.mapper.toAsteroidDetails
import com.example.nasa.feature.data.model.AsteroidDetailsApi
import com.example.nasa.feature.data.model.AsteroidDetailsResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.url

internal class SpaceRepository(
    private val httpClient: HttpClient
) {

    suspend fun getAsteroidDetailsById(id: Int): AsteroidDetails {
        val response = requireNotNull(getApiResult(id))
        return response.toAsteroidDetails()
    }

    fun getAsteroidsList(): List<Asteroid> {
        return generateAsteroidsList()
    }

    suspend fun getPhotoByLanAndLon(
        lat: Int,
        lon: Int
    ): String {
        return httpClient.get{
            url("planetary/earth/imagery")
            parameter("lon", lon)
            parameter("lat", lat)
        }.body()
    }

    fun getAboutSpaceScreenInfo(): List<CosmicBody> {
        return generateCosmicBodies()
    }

    private suspend fun getApiResult(id: Int): AsteroidDetailsApi {
        return  httpClient.get {
            url("neo/rest/v1/neo/${id}")
        }.body<AsteroidDetailsApi>()
    }

    private fun generateAsteroidsList(): List<Asteroid> {
        return buildList(3) {
            add(
                Asteroid(
                    id = 3542519,
                    title = "Big asteroid",
                    imageUrl = "https://newizv.ru/attachments/2e520834e06c61084fd8866fe9179a4e6fd49760/store/crop/0/0/1200/630/1920/0/0/181d988355f3451dd5ff634eec0d3ca99087d8620dba6d2c2bc03ca37929/ae59f4b1198585fb6c5de02f655b2b62f1e99fe59c8dafe76c1a2b32aa65",
                    description = "243 Ida is an asteroid in the Koronis family of the asteroid belt. Discovered in 1884 by Johann Palisa, it is notable for its moon, Dactyl, making it the first asteroid found to have a satellite. Ida is primarily composed of silicate rock and has an irregular shape.",
                )
            )
            add(
                Asteroid(
                    id = 3542520,
                    title = "Normal Asteroid",
                    imageUrl = "https://fikiwiki.com/uploads/posts/2022-02/1645055170_16-fikiwiki-com-p-kartinki-asteroidi-18.jpg",
                    description = "433 Eros is a near-Earth asteroid and one of the largest of its kind. Discovered in 1898 by Carl Gustav Witt, it was the first asteroid to be orbited by a spacecraft (NEAR Shoemaker in 2000). Eros has an elongated, peanut-like shape and consists mostly of silicate materials.",
                )
            )
            add(
                Asteroid(
                    id = 3542521,
                    title = "Small asteroid",
                    imageUrl = "https://fikiwiki.com/uploads/posts/2022-02/1645055106_37-fikiwiki-com-p-kartinki-asteroidi-43.jpg",
                    description = "4 Vesta is one of the largest objects in the asteroid belt, discovered in 1807 by Heinrich Wilhelm Olbers. It is unique due to its differentiated interior and a massive crater at its south pole. Vesta's composition is similar to that of terrestrial planets, consisting of a crust, mantle, and core",
                )
            )
        }
    }

    private fun generateCosmicBodies(): List<CosmicBody> {
        return buildList(2) {
            add(
                CosmicBody(
                    "Asteroids",
                    "https://rosspectr.ru/wp-content/uploads/9/d/6/9d65625aaa2558891e23270e23d75b88.jpeg"
                )
            )
            add(
                CosmicBody(
                    "Planets",
                    "https://img.tv100.com/rcman/Cw1280h720q95gc/storage/files/images/2023/09/11/kuresel-isinma-en-son-asd-H3Qu_cover.jpg"
                )
            )
        }
    }
}
