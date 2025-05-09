package com.nikolai.instagramhelper.di.modules

import com.nikolai.instagramhelper.services.settingsService.SettingsService
import com.nikolai.instagramhelper.services.settingsService.SharedPreferencesService
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

actual fun platformModule() = module {
    single<SettingsService> {
        SharedPreferencesService(androidContext())
    }
}