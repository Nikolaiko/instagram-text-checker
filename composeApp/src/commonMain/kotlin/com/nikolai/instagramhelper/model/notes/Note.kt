package com.nikolai.instagramhelper.model.notes

data class Note(
    val id: Int,
    val title: String,
    val text: String,
    val createdDate: Long
)
