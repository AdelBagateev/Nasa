package com.example.nasa

sealed class DestinationScreen(val route: String) {

    object AboutSpaceScreen : DestinationScreen(route = ABOUT_SPACE_ROUTE)

    object AsteroidsListScreen : DestinationScreen(route = ASTEROID_LIST_ROUTE)

    object AsteroidDetailsScreen : DestinationScreen(route = ASTEROID_DETAILS_ROUTE)

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }

    companion object {

        private const val ABOUT_SPACE_ROUTE = "ABOUT_SPACE"
        private const val ASTEROID_LIST_ROUTE = "ASTEROID_LIST"
        private const val ASTEROID_DETAILS_ROUTE = "ASTEROID_DETAILS"
    }
}
