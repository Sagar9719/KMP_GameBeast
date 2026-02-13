package com.timilite.firstkmpproject.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import ui.screens.SearchScreen

object SearchNavGraph : BaseNavGraph {
    sealed class Dest(val route: String) {
        data object Root : Dest(route = "/search-root")
        data object Search : Dest(route = "/search")
    }

    override fun build(
        modifier: Modifier,
        navHostController: NavHostController,
        navGraphBuilder: NavGraphBuilder
    ) {
        navGraphBuilder.navigation(route = Dest.Root.route, startDestination = Dest.Search.route) {
            composable(route = Dest.Search.route) {
                SearchScreen(
                    modifier = modifier.fillMaxSize(),
                    onClick = { gameId ->
                        navHostController.navigate(route = GameNavGraph.Destination.Details.getRoute(gameId))
                    },
                    onBackClick = {
                    navHostController.popBackStack()
                })
            }
        }
    }
}