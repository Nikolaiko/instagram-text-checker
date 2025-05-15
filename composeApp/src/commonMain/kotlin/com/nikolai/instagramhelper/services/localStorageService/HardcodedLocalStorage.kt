package com.nikolai.instagramhelper.services.localStorageService

import com.nikolai.instagramhelper.model.notes.ShortNoteInfo
import kotlinx.datetime.Clock

class HardcodedLocalStorage: LocalStorageService {
    override suspend fun getAllNotes(): List<ShortNoteInfo> {
        return listOf<ShortNoteInfo>(
            ShortNoteInfo(id = 0, title = "Title 1", createdDate = Clock.System.now().epochSeconds),
            ShortNoteInfo(id = 1, title = "Title 2", createdDate = Clock.System.now().epochSeconds),
            ShortNoteInfo(id = 2, title = "Title 3", createdDate = Clock.System.now().epochSeconds),
            ShortNoteInfo(id = 3, title = "Title 4", createdDate = Clock.System.now().epochSeconds),
            ShortNoteInfo(id = 4, title = "Title 5", createdDate = Clock.System.now().epochSeconds),
        )
    }
}