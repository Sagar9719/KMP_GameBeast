package com.timilite.firstkmpproject.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import game.ui.game.screens.GameScreen
import game.ui.gameDetails.screens.GameDetailsScreen

object GameNavGraph : BaseNavGraph {
    sealed class Destination(val route: String) {
        data object Root : Destination(route = "/game-root")
        data object Game : Destination(route = "/game")
        data object Details : Destination("/game_details/{id}") {
            fun getRoute(id: Int) = "/game_details/${id}"
        }
    }

    override fun build(
        modifier: Modifier,
        navHostController: NavHostController,
        navGraphBuilder: NavGraphBuilder
    ) {
        navGraphBuilder.navigation(
            route = Destination.Root.route,
            startDestination = Destination.Game.route
        ) {
            composable(route = Destination.Game.route) {
                GameScreen(
                    modifier = modifier.fillMaxSize(), onFavouriteClick = {
                        navHostController.navigate(route = FavouriteNavGraph.Dest.Favorite.route)
                    },
                    onSearchClick = {
                        navHostController.navigate(route = SearchNavGraph.Dest.Search.route)
                    },
                    onGameCardClick = {gameId ->
                        navHostController.navigate(route = Destination.Details.getRoute(gameId))
                    })
            }

            composable(route = Destination.Details.route) {
                val id = it.arguments?.getString("id")
                GameDetailsScreen(modifier = modifier.fillMaxSize(), id = id.toString(), onBackClick = {
                    navHostController.popBackStack()
                })
            }
        }
    }
}