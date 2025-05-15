package com.nikolai.instagramhelper.features.workWithNoteFeature.state

import com.nikolai.instagramhelper.model.notes.Note

data class WorkWithNoteViewState(
    val note: Note?,
    val currentNoteTitle: String,
    val currentNoteText: String
) {
    companion object {
        val initialState = WorkWithNoteViewState(
            note = null,
            currentNoteTitle = "",
            currentNoteText = ""
        )
    }
}
