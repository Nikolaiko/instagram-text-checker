package com.nikolai.instagramhelper.model

import com.nikolai.instagramhelper.model.notes.Note
import com.nikolai.instagramhelper.model.notes.RoomDBNote
import com.nikolai.instagramhelper.model.notes.ShortNoteInfo

fun RoomDBNote.toShortNoteData() = ShortNoteInfo(
    id = id,
    title = title,
    createdDate = createdDate
)

fun RoomDBNote.toNoteData() = Note(
    id = id,
    title = title,
    createdDate = createdDate,
    text = text
)


fun Note.toRoomDBNote() = RoomDBNote(
    id = id,
    title = title,
    text = text,
    createdDate = createdDate
)