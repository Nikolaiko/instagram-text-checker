package com.nikolai.instagramhelper.di.modules

import com.nikolai.instagramhelper.services.localStorageService.HardcodedLocalStorage
import com.nikolai.instagramhelper.services.localStorageService.LocalStorageService
import com.nikolai.instagramhelper.services.navigationService.AppNavigationService
import com.nikolai.instagramhelper.services.navigationService.NavigationControllerService
import org.koin.dsl.module

val provideServicesModule = module {
    single<AppNavigationService> { NavigationControllerService() }
    single<LocalStorageService> { HardcodedLocalStorage() }
}