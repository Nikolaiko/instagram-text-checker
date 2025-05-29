package com.nikolai.instagramhelper.features.notesListFeature.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nikolai.instagramhelper.features.notesListFeature.state.NotesListViewState
import com.nikolai.instagramhelper.model.localStorage.DbEvents
import com.nikolai.instagramhelper.model.navigation.AppDestination
import com.nikolai.instagramhelper.model.notes.ShortNoteInfo
import com.nikolai.instagramhelper.services.localStorageService.LocalStorageService
import com.nikolai.instagramhelper.services.localStorageService.room.NotesDataSource
import com.nikolai.instagramhelper.services.localStorageService.room.base.AppDatabase
import com.nikolai.instagramhelper.services.navigationService.AppNavigationService
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class NotesListViewModel(
    private val navigationService: AppNavigationService,
    private val localStorageService: LocalStorageService,
): ViewModel() {
    private val _stateFlow = MutableStateFlow(NotesListViewState.initialState)
    val stateFlow: StateFlow<NotesListViewState>
        get() = _stateFlow
            .asStateFlow()
            .stateIn(
                viewModelScope,
                SharingStarted.WhileSubscribed(5000),
                NotesListViewState.initialState
            )

    init {
        viewModelScope.launch {
            updateNotesList()
        }

        viewModelScope.launch {
            localStorageService.notesListFlow.collect {
                updateNotesList()
            }
        }
    }

    fun createNewNote() {
        navigationService.navigateTo(
            AppDestination.WorkWithNoteScreen(null),
            false
        )
    }

    fun editNote(id: Int) {
        navigationService.navigateTo(
            AppDestination.WorkWithNoteScreen(id.toString()),
            false
        )
    }

    private suspend fun updateNotesList() {
        val notes = localStorageService.getAllNotes()
        _stateFlow.tryEmit(_stateFlow.value.copy(notesList = notes))
    }
}