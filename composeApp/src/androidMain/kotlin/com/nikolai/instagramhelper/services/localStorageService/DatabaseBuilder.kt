package com.nikolai.instagramhelper.services.localStorageService

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.nikolai.instagramhelper.services.localStorageService.room.base.AppDatabase
import kotlinx.coroutines.Dispatchers

fun getDatabaseBuilder(ctx: Context): RoomDatabase.Builder<AppDatabase> {
    val appContext = ctx.applicationContext
    val dbFile = appContext.getDatabasePath("my_room.db")
    return Room.databaseBuilder<AppDatabase>(
        context = appContext,
        name = dbFile.absolutePath
    )
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
}

fun getDatabase(ctx: Context): AppDatabase {
    return getDatabaseBuilder(ctx).build()
}