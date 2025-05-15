package com.nikolai.instagramhelper.di.modules

import com.nikolai.instagramhelper.services.settingsService.HardCodedSettingsService
import com.nikolai.instagramhelper.services.settingsService.SettingsService
import org.koin.dsl.module

val provideTestModule = module {
    single<SettingsService> {
        HardCodedSettingsService(false)
    }
}