package rs.ovp.hiltviewmodelinjectsample.navigation

import androidx.navigation.NavHostController
import rs.ovp.hiltviewmodelinjectsample.navigation.Destination.Home

class Navigator(navController: NavHostController) {

    val navigateBack: () -> Unit = {
        navController.popBackStack()
    }
    val navigateToPlayer: () -> Unit = {
        navController.navigate(Home)
    }
}