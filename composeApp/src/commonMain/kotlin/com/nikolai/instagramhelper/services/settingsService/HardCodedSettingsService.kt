package com.nikolai.instagramhelper.services.settingsService

class HardCodedSettingsService(
    private val onBoardingCompleted: Boolean
): SettingsService {
    override fun isOnboardingCompleted() = onBoardingCompleted
    override fun setOnboardingFinished() { }
}