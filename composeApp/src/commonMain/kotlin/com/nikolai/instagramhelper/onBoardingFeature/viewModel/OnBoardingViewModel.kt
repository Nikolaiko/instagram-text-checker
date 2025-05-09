package com.nikolai.instagramhelper.onBoardingFeature.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nikolai.instagramhelper.appFeature.state.AppFeatureState
import com.nikolai.instagramhelper.onBoardingFeature.state.OnBoardingScreenState
import com.nikolai.instagramhelper.services.settingsService.SettingsService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn

class OnBoardingViewModel(
    private val settingsService: SettingsService
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
    }
}