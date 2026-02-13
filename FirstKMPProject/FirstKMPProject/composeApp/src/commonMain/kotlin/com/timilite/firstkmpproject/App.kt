package com.timilite.firstkmpproject

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.timilite.firstkmpproject.navigation.FavouriteNavGraph
import com.timilite.firstkmpproject.navigation.GameNavGraph
import com.timilite.firstkmpproject.navigation.SearchNavGraph
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        MaterialTheme {
            val navHostController = rememberNavController()
            NavHost(
                navController = navHostController,
                startDestination = GameNavGraph.Destination.Root.route
            ) {
                listOf(
                    GameNavGraph,
                    SearchNavGraph,
                    FavouriteNavGraph
                ).forEach {
                    it.build(
                        modifier = Modifier.fillMaxSize(),
                        navHostController = navHostController,
                        navGraphBuilder = this
                    )
                }
            }
        }
    }
}