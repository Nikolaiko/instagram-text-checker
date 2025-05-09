package com.nikolai.instagramhelper.appFeature.view

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nikolai.instagramhelper.appFeature.state.AppFeatureState
import com.nikolai.instagramhelper.appFeature.viewModel.AppViewModel
import com.nikolai.instagramhelper.model.navigation.AppDestination
import com.nikolai.instagramhelper.notesListFeature.view.NotesListView
import com.nikolai.instagramhelper.onBoardingFeature.views.OnBoardingScreenView
import org.koin.compose.viewmodel.koinViewModel


@Composable
fun AppView(
    viewModel: AppViewModel  = koinViewModel(),
    navController: NavHostController = rememberNavController()
) {
    Scaffold {
        val uiState = viewModel.stateFlow.collectAsState(AppFeatureState.initialState)

        NavHost(
            navController = navController,
            startDestination = viewModel.getInitialScreen().route
        ) {
            composable(route = AppDestination.OnBoardingScreen.route) {
                OnBoardingScreenView()
            }
            composable(route = AppDestination.NotesListScreen.route) {
                NotesListView()
            }
        }
    }
}