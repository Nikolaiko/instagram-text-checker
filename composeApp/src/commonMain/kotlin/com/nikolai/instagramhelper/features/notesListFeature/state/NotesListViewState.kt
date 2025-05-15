package com.nikolai.instagramhelper.features.notesListFeature.state

import com.nikolai.instagramhelper.model.notes.ShortNoteInfo
import org.koin.viewmodel.emptyState

data class NotesListViewState(
    val notesList: List<ShortNoteInfo>
) {
    companion object {
        val initialState = NotesListViewState(emptyList())
    }
}
