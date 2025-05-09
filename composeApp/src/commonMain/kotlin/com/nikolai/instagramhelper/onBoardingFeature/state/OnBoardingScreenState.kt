package com.nikolai.instagramhelper.onBoardingFeature.state

data class OnBoardingScreenState(
    val pageNumber: Int = 0
) {
    companion object {
        val initialState = OnBoardingScreenState()
    }
}
