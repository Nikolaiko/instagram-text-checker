package com.nikolai.instagramhelper.di.modules

import com.nikolai.instagramhelper.services.localStorageService.HardcodedLocalStorage
import com.nikolai.instagramhelper.services.localStorageService.LocalStorageService
import com.nikolai.instagramhelper.services.localStorageService.room.NotesDataSource
import com.nikolai.instagramhelper.services.localStorageService.room.NotesRoomImplementation
import com.nikolai.instagramhelper.services.localStorageService.room.RoomNotesDao
import com.nikolai.instagramhelper.services.localStorageService.room.RoomStorageService
import com.nikolai.instagramhelper.services.localStorageService.room.base.AppDatabase
import com.nikolai.instagramhelper.services.localStorageService.room.base.getNotesDao
import com.nikolai.instagramhelper.services.localStorageService.room.base.getRoomDatabase
import com.nikolai.instagramhelper.services.navigationService.AppNavigationService
import com.nikolai.instagramhelper.services.navigationService.NavigationControllerService
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import kotlin.math.sin

val provideServicesModule = module {
    single<AppNavigationService> { NavigationControllerService() }
    //single<LocalStorageService> { HardcodedLocalStorage() }
    single<LocalStorageService> { RoomStorageService(get()) }
}


val provideRoomDatabaseModule = module {
    single<AppDatabase> { getRoomDatabase(get()) }
    single<RoomNotesDao> { getNotesDao(get()) }
    single<NotesDataSource> { NotesRoomImplementation(get()) }
}