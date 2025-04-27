package com.nikolai.instagramhelper.services.settingsService

interface SettingsService {
    fun isOnboardingCompleted(): Boolean
    fun setOnboardingFinished()
}