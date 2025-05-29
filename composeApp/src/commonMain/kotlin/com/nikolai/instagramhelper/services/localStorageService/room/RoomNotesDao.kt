package com.nikolai.instagramhelper.services.localStorageService.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.nikolai.instagramhelper.model.notes.RoomDBNote

@Dao
interface RoomNotesDao {
    @Insert
    suspend fun addNote(note: RoomDBNote)

    @Update
    suspend fun updateNote(note: RoomDBNote)

    @Query("SELECT * FROM notes ORDER BY createdDate DESC")
    suspend fun getAllNotes(): List<RoomDBNote>

    @Query("SELECT * FROM notes WHERE id=:id ")
    suspend fun getNoteById(id: Int): List<RoomDBNote>
}