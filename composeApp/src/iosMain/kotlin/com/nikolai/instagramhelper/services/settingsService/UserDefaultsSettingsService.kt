package com.nikolai.instagramhelper.services.settingsService

import com.nikolai.instagramhelper.model.consts.SettingsKeyNames.onBoardingPassedSettingName
import platform.Foundation.NSUserDefaults

class UserDefaultsSettingsService: SettingsService {
    override fun isOnboardingCompleted(): Boolean {
        return NSUserDefaults.standardUserDefaults.boolForKey(
            onBoardingPassedSettingName
        )
    }

    override fun setOnboardingFinished() {
        NSUserDefaults.standardUserDefaults.setBool(
            true,
            onBoardingPassedSettingName)
    }
}