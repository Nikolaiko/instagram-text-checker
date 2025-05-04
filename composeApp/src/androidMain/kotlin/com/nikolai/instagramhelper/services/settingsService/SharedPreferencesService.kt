package com.nikolai.instagramhelper.services.settingsService

import android.content.Context
import android.content.SharedPreferences
import com.nikolai.instagramhelper.model.consts.SettingsKeyNames.onBoardingPassedSettingName
import androidx.core.content.edit

class SharedPreferencesService(
    private val context: Context,
): SettingsService {

    private val preferences: SharedPreferences = context.getSharedPreferences(
        tag,
        Context.MODE_PRIVATE
    )

    override fun isOnboardingCompleted() = preferences.getBoolean(
        onBoardingPassedSettingName,
        false
    )

    override fun setOnboardingFinished() {
        preferences.edit {
            putBoolean(onBoardingPassedSettingName, true)
        }
    }

    companion object {
        const val tag = "SharedPrefsUserData"
    }
}