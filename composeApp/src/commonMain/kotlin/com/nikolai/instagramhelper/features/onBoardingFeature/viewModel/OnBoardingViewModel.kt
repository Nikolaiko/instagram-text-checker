package com.nikolai.instagramhelper.features.onBoardingFeature.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nikolai.instagramhelper.features.onBoardingFeature.state.OnBoardingScreenState
import com.nikolai.instagramhelper.model.navigation.AppDestination
import com.nikolai.instagramhelper.services.navigationService.AppNavigationService
import com.nikolai.instagramhelper.services.settingsService.SettingsService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn

class OnBoardingViewModel(
    private val settingsService: SettingsService,
    private val navigationService: AppNavigationService
): ViewModel() {
    private val _stateFlow = MutableStateFlow(OnBoardingScreenState.initialState)
    val stateFlow: StateFlow<OnBoardingScreenState>
        get() = _stateFlow
            .asStateFlow()
            .stateIn(
                viewModelScope,
                SharingStarted.WhileSubscribed(5000),
                OnBoardingScreenState.initialState
            )

    fun finishOnBoarding() {
        settingsService.setOnboardingFinished()
        navigationService.navigateTo(AppDestination.NotesListScreen, true)
    }
}