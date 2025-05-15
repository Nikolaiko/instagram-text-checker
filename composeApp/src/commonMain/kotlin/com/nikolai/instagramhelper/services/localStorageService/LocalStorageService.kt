package com.nikolai.instagramhelper.services.localStorageService

import com.nikolai.instagramhelper.model.notes.Note
import com.nikolai.instagramhelper.model.notes.ShortNoteInfo

interface LocalStorageService {
    suspend fun getAllNotes(): List<ShortNoteInfo>
}