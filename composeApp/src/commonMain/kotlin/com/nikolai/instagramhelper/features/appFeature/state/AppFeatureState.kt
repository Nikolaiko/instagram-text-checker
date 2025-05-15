package com.nikolai.instagramhelper.features.appFeature.state

import com.nikolai.instagramhelper.model.navigation.AppDestination

data class AppFeatureState(
    val initialScreen: AppDestination
) {
    companion object {
        val initialState = AppFeatureState(initialScreen = AppDestination.OnBoardingScreen)
    }
}
