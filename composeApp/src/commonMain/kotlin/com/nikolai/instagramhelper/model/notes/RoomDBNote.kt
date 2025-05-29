package com.nikolai.instagramhelper.model.notes

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class RoomDBNote(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val title: String,
    val text: String,
    val createdDate: Long
)