package rs.ovp.hiltviewmodelinjectsample.ui.home

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.flowWithLifecycle
import androidx.hilt.navigation.compose.hiltViewModel
import rs.ovp.hiltviewmodelinjectsample.states.HomeState
import rs.ovp.hiltviewmodelinjectsample.viewmodels.HomeViewModel

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel()) {
    val lifecycleOwner = LocalLifecycleOwner.current
    val lifecycleAwareHomeState = remember(viewModel.state, lifecycleOwner) {
        viewModel.state.flowWithLifecycle(lifecycleOwner.lifecycle)
    }

    val homeState by lifecycleAwareHomeState.collectAsState(viewModel.state.value)

    HomeContent(homeState)
}

@Composable
fun HomeContent(homeState: HomeState) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (homeState.isLoading) {
            CircularProgressIndicator()
        } else {
            Text(text = homeState.helloMessage ?: "No Data")
        }
    }
}

@Preview
@Composable
fun HomeContentLoadingPreview() {
    HomeContent(homeState = HomeState(isLoading = true))
}