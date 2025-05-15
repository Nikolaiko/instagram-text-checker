package com.nikolai.instagramhelper.features.appFeature.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nikolai.instagramhelper.features.appFeature.state.AppFeatureState
import com.nikolai.instagramhelper.model.navigation.AppDestination
import com.nikolai.instagramhelper.services.settingsService.SettingsService
import kotlinx.coroutines.flow.*
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
            _stateFlow.emit(stateFlow.value.copy(initialScreen = currentDestination))
        }
    }

    fun getInitialScreen() = when(settingsService.isOnboardingCompleted()) {
        true -> AppDestination.NotesListScreen
        false -> AppDestination.OnBoardingScreen
    }
}