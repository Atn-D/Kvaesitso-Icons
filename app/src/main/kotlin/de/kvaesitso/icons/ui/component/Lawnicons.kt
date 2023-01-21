package de.kvaesitso.icons.ui.component

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import de.kvaesitso.icons.ui.destination.About
import de.kvaesitso.icons.ui.destination.Acknowledgement
import de.kvaesitso.icons.ui.destination.Acknowledgements
import de.kvaesitso.icons.ui.destination.Contributors
import de.kvaesitso.icons.ui.destination.Home
import de.kvaesitso.icons.ui.theme.LawniconsTheme
import de.kvaesitso.icons.ui.util.Destinations

@Composable
@ExperimentalFoundationApi
@OptIn(ExperimentalAnimationApi::class)
fun Lawnicons() {
    val navController = rememberAnimatedNavController()

    LawniconsTheme {
        SystemUi()
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background,
        ) {
            AnimatedNavHost(
                navController = navController,
                startDestination = Destinations.HOME,
            ) {
                composable(route = Destinations.HOME) {
                    Home(navController = navController)
                }
                composable(route = Destinations.ACKNOWLEDGEMENTS) {
                    Acknowledgements(navController = navController)
                }
                composable(
                    route = "${Destinations.ACKNOWLEDGEMENT}/{id}",
                    arguments = listOf(
                        navArgument(
                            name = "id",
                            builder = { type = NavType.StringType },
                        ),
                    ),
                ) { backStackEntry ->
                    Acknowledgement(
                        name = backStackEntry.arguments?.getString("id"),
                        navController = navController,
                    )
                }
                composable(route = Destinations.ABOUT) {
                    About(navController = navController)
                }
                composable(route = Destinations.CONTRIBUTORS) {
                    Contributors(navController = navController)
                }
            }
        }
    }
}
