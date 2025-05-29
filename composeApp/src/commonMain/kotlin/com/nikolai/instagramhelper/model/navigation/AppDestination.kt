package com.nikolai.instagramhelper.model.navigation

import com.nikolai.instagramhelper.model.consts.AppRoutesStrings

sealed class AppDestination(
    val route: String,
) {
    data object OnBoardingScreen: AppDestination(route = AppRoutesStrings.onBoarding)
    data object NotesListScreen: AppDestination(route = AppRoutesStrings.notesList)
    data class WorkWithNoteScreen(val noteId: String?): AppDestination(
        route = when(noteId == null) {
            true -> AppRoutesStrings.currentNote
            false -> "${AppRoutesStrings.currentNote}/$noteId"
        }
    )
}