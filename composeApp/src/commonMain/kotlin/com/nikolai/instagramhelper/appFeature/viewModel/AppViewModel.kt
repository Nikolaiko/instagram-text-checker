package com.nikolai.instagramhelper.appFeature.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nikolai.instagramhelper.appFeature.state.AppFeatureState
import com.nikolai.instagramhelper.model.navigation.AppDestination
import com.nikolai.instagramhelper.services.settingsService.SettingsService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class AppViewModel(
    private val settingsService: SettingsService
): ViewModel() {
    private val _stateFlow = MutableStateFlow(AppFeatureState.initialState)
    val stateFlow: StateFlow<AppFeatureState>
        get() = _stateFlow
            .asStateFlow()
            .stateIn(
                viewModelScope,
                SharingStarted.WhileSubscribed(5000),
                AppFeatureState.initialState
            )

    init {
        val currentDestination = when(settingsService.isOnboardingCompleted()) {
            true -> AppDestination.NotesListScreen
            false -> AppDestination.OnBoardingScreen
        }

        viewModelScope.launch {
            println(stateFlow.value.copy(initialScreen = currentDestination))
            _stateFlow.emit(stateFlow.value.copy(initialScreen = currentDestination))
        }
    }

    fun getInitialScreen() = when(settingsService.isOnboardingCompleted()) {
        true -> AppDestination.NotesListScreen
        false -> AppDestination.OnBoardingScreen
    }
}