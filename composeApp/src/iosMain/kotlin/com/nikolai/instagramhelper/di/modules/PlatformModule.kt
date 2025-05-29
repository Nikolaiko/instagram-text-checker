package com.nikolai.instagramhelper.di.modules

import androidx.room.RoomDatabase
import com.nikolai.instagramhelper.services.localStorageService.getDatabaseBuilder
import com.nikolai.instagramhelper.services.localStorageService.room.base.AppDatabase
import com.nikolai.instagramhelper.services.settingsService.SettingsService
import com.nikolai.instagramhelper.services.settingsService.UserDefaultsSettingsService
import org.koin.dsl.module

actual fun platformModule() = module {
    single<SettingsService> {
        UserDefaultsSettingsService()
    }
    single<RoomDatabase.Builder<AppDatabase>> {
        getDatabaseBuilder()
    }
}