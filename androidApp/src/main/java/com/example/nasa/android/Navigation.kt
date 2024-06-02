package com.example.nasa.android

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.nasa.DestinationScreen
import com.example.nasa.feature.about_space.AboutSpaceScreen
import com.example.nasa.feature.asteroid_details.AsteroidDetailsScreen
import com.example.nasa.feature.asteroid_list.AsteroidListScreen

private const val ID = "ID"
private const val DEFAULT_INT_ARG = -1

@Composable
fun Navigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = DestinationScreen.AboutSpaceScreen.route,
    ) {

        composable(
            route = DestinationScreen.AboutSpaceScreen.route
        ) {
            AboutSpaceScreen(navController = navController)
        }

        composable(
            route = DestinationScreen.AsteroidsListScreen.route,
        ) {
            AsteroidListScreen(navController = navController)
        }

        composable(
            route = DestinationScreen.AsteroidDetailsScreen.route + "/{$ID}",
            arguments = listOf(
                navArgument(ID) {
                    type = NavType.IntType
                    defaultValue = DEFAULT_INT_ARG
                    nullable = false
                }
            )
        ) { entry ->
            entry.arguments?.getInt(ID)?.let {
                AsteroidDetailsScreen(
                    id = it,
                    navController = navController
                )
            }
        }
    }
}
