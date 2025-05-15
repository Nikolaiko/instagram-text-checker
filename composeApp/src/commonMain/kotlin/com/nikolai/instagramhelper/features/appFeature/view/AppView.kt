package com.nikolai.instagramhelper.features.appFeature.view

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nikolai.instagramhelper.features.appFeature.state.AppFeatureState
import com.nikolai.instagramhelper.features.appFeature.viewModel.AppViewModel
import com.nikolai.instagramhelper.features.notesListFeature.view.NotesListView
import com.nikolai.instagramhelper.features.onBoardingFeature.views.OnBoardingScreenView
import com.nikolai.instagramhelper.features.workWithNoteFeature.view.WorkWithNoteView
import com.nikolai.instagramhelper.model.navigation.AppDestination
import com.nikolai.instagramhelper.services.navigationService.AppNavigationService
import org.koin.compose.koinInject
import org.koin.compose.viewmodel.koinViewModel


@Composable
fun AppView(
    viewModel: AppViewModel = koinViewModel(),
    navController: NavHostController = rememberNavController()
) {
    koinInject<AppNavigationService>().setNavigationController(navController)

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
            composable(route = AppDestination.WorkWithNoteScreen.route) {
                WorkWithNoteView()
            }
        }
    }
}