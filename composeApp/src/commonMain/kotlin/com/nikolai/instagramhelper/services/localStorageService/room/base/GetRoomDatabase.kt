package com.nikolai.instagramhelper.services.localStorageService.room.base

import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

fun getRoomDatabase(
    builder: RoomDatabase.Builder<AppDatabase>
): AppDatabase {
    try {
        return builder
            .addMigrations()
            .fallbackToDestructiveMigrationOnDowngrade(true)
            .setDriver(BundledSQLiteDriver())
            .setQueryCoroutineContext(Dispatchers.IO)
            .build()
    } catch (ex: Exception) {
        println("Exception: $ex")
        return  builder.build()
    }
}

fun getNotesDao(appDatabase: AppDatabase) = appDatabase.getNotesDao()