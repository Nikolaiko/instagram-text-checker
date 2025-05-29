package com.nikolai.instagramhelper.services.localStorageService.room

import com.nikolai.instagramhelper.model.notes.RoomDBNote

class NotesRoomImplementation(
    private val notesDao: RoomNotesDao
): NotesDataSource {

    override suspend fun insertNote(note: RoomDBNote) {
        notesDao.addNote(note)
    }

    override suspend fun updateNote(note: RoomDBNote) {
        notesDao.updateNote(note)
    }

    override suspend fun getAllNotes(): List<RoomDBNote> = notesDao.getAllNotes()

    override suspend fun getNoteById(id: Int): RoomDBNote? = notesDao.getNoteById(id).first()
}