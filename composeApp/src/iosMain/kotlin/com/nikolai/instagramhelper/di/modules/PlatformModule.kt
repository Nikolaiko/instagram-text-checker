package com.nikolai.instagramhelper.di.modules

import com.nikolai.instagramhelper.services.settingsService.SettingsService
import com.nikolai.instagramhelper.services.settingsService.UserDefaultsSettingsService
import org.koin.dsl.module

actual fun platformModule() = module {
    single<SettingsService> {
        UserDefaultsSettingsService()
    }
}