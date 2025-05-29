package com.nikolai.instagramhelper.services.localStorageService.room.base

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import com.nikolai.instagramhelper.model.consts.DatabaseConstants
import com.nikolai.instagramhelper.model.notes.RoomDBNote
import com.nikolai.instagramhelper.services.localStorageService.room.RoomNotesDao

@Database(entities = [RoomDBNote::class], version = DatabaseConstants.dbVersion)
@ConstructedBy(AppDatabaseConstructor::class)
abstract class AppDatabase: RoomDatabase() {
    abstract fun getNotesDao(): RoomNotesDao
}