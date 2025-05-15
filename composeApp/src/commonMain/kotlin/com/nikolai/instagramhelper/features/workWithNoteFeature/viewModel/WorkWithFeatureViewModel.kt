package com.nikolai.instagramhelper.features.workWithNoteFeature.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nikolai.instagramhelper.features.onBoardingFeature.state.OnBoardingScreenState
import com.nikolai.instagramhelper.features.workWithNoteFeature.state.WorkWithNoteViewState
import com.nikolai.instagramhelper.services.navigationService.AppNavigationService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn

class WorkWithFeatureViewModel(
    private val navigationService: AppNavigationService
): ViewModel() {
    private val _stateFlow = MutableStateFlow(WorkWithNoteViewState.initialState)
    val stateFlow: StateFlow<WorkWithNoteViewState>
        get() = _stateFlow
            .asStateFlow()
            .stateIn(
                viewModelScope,
                SharingStarted.WhileSubscribed(5000),
                WorkWithNoteViewState.initialState
            )

    fun backToMainScreen() {
        navigationService.popBackStack()
    }
}