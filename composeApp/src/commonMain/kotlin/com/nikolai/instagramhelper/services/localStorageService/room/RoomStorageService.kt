package com.nikolai.instagramhelper.services.localStorageService.room

import com.nikolai.instagramhelper.model.localStorage.DbEvents
import com.nikolai.instagramhelper.model.notes.Note
import com.nikolai.instagramhelper.model.notes.ShortNoteInfo
import com.nikolai.instagramhelper.model.toNoteData
import com.nikolai.instagramhelper.model.toRoomDBNote
import com.nikolai.instagramhelper.model.toShortNoteData
import com.nikolai.instagramhelper.services.localStorageService.LocalStorageService
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.datetime.Clock

class RoomStorageService(
    private val notesDataSource: NotesDataSource
): LocalStorageService {
    override val notesListFlow: SharedFlow<DbEvents>
        get() = _notesListFlow
    private val _notesListFlow = MutableSharedFlow<DbEvents>()


    override suspend fun getAllNotes(): List<ShortNoteInfo> {
        return notesDataSource.getAllNotes().map {
            it.toShortNoteData()
        }
    }

    override suspend fun saveNote(note: Note) {
        notesDataSource.insertNote(note.toRoomDBNote())
        _notesListFlow.emit(DbEvents.add)
    }

    override suspend fun updateNote(note: Note) {
        notesDataSource.updateNote(note.toRoomDBNote())
        _notesListFlow.emit(DbEvents.update)
    }

    override suspend fun getNoteById(noteId: Int): Note? {
        val note = notesDataSource.getNoteById(noteId)?.toNoteData()
        return note
    }
}