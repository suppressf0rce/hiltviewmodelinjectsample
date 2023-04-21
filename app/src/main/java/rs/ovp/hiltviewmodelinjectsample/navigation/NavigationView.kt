package rs.ovp.hiltviewmodelinjectsample.navigation

import androidx.compose.animation.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import rs.ovp.hiltviewmodelinjectsample.ui.home.HomeScreen


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun NavigationView() {
    val navController = rememberNavController()
    val navigator = remember(navController) { Navigator(navController) }

    NavHost(
        navController = navController,
        startDestination = Destination.Home,
        modifier = Modifier.fillMaxSize()
    ) {
        composable(Destination.Home) {
            HomeScreen()
        }
    }
}