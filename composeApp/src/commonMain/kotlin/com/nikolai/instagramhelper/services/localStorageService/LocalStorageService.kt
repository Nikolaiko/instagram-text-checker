package com.nikolai.instagramhelper.services.localStorageService

import com.nikolai.instagramhelper.model.localStorage.DbEvents
import com.nikolai.instagramhelper.model.notes.Note
import com.nikolai.instagramhelper.model.notes.ShortNoteInfo
import kotlinx.coroutines.flow.SharedFlow

interface LocalStorageService {
    val notesListFlow: SharedFlow<DbEvents>

    suspend fun getAllNotes(): List<ShortNoteInfo>
    suspend fun saveNote(note: Note)

    suspend fun updateNote(note: Note)

    suspend fun getNoteById(noteId: Int): Note?
}