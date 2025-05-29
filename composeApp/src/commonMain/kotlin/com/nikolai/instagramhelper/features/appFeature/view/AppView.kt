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
import com.nikolai.instagramhelper.features.workWithNoteFeature.viewModel.WorkWithFeatureViewModel
import com.nikolai.instagramhelper.model.consts.AppRoutesStrings
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
            composable(route = AppRoutesStrings.onBoarding) {
                OnBoardingScreenView()
            }
            composable(route = AppRoutesStrings.notesList) {
                NotesListView()
            }
            composable(route = "${AppRoutesStrings.currentNote}/{noteId}") {
                val noteId = it.arguments?.getString("noteId")
                val viewModel: WorkWithFeatureViewModel = koinViewModel()
                if (noteId != null) {
                    viewModel.initWithNoteId(noteId)
                }
                WorkWithNoteView(viewModel)
            }
        }
    }
}