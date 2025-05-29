package com.nikolai.instagramhelper.services.localStorageService

import com.nikolai.instagramhelper.model.localStorage.DbEvents
import com.nikolai.instagramhelper.model.notes.Note
import com.nikolai.instagramhelper.model.notes.ShortNoteInfo
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.datetime.Clock

class HardcodedLocalStorage: LocalStorageService {
    override val notesListFlow: SharedFlow<DbEvents>
        get() = _notesListFlow
    private val _notesListFlow = MutableSharedFlow<DbEvents>()

    override suspend fun getAllNotes(): List<ShortNoteInfo> {
        return listOf<ShortNoteInfo>(
            ShortNoteInfo(id = 0, title = "Title 1", createdDate = Clock.System.now().epochSeconds),
            ShortNoteInfo(id = 1, title = "Title 2", createdDate = Clock.System.now().epochSeconds),
            ShortNoteInfo(id = 2, title = "Title 3", createdDate = Clock.System.now().epochSeconds),
            ShortNoteInfo(id = 3, title = "Title 4", createdDate = Clock.System.now().epochSeconds),
            ShortNoteInfo(id = 4, title = "Title 5", createdDate = Clock.System.now().epochSeconds),
        )
    }

    override suspend fun saveNote(note: Note) { }
    override suspend fun updateNote(note: Note) { }

    override suspend fun getNoteById(noteId: Int): Note? = Note(
        1, "", "", 0)
}