package com.nikolai.instagramhelper.services.localStorageService.room

import com.nikolai.instagramhelper.model.notes.RoomDBNote

interface NotesDataSource {
    suspend fun insertNote(note: RoomDBNote)
    suspend fun updateNote(note: RoomDBNote)
    suspend fun getAllNotes(): List<RoomDBNote>
    suspend fun getNoteById(id: Int): RoomDBNote?
}