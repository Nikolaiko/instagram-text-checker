package com.nikolai.instagramhelper.features.notesListFeature.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nikolai.instagramhelper.features.notesListFeature.state.NotesListViewState
import com.nikolai.instagramhelper.model.navigation.AppDestination
import com.nikolai.instagramhelper.model.notes.ShortNoteInfo
import com.nikolai.instagramhelper.services.localStorageService.LocalStorageService
import com.nikolai.instagramhelper.services.navigationService.AppNavigationService
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class NotesListViewModel(
    private val localStorageService: LocalStorageService,
    private val navigationService: AppNavigationService
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
            val notes = localStorageService.getAllNotes()
            _stateFlow.tryEmit(_stateFlow.value.copy(notesList = notes))
        }
    }

    fun createNewNote() {
        navigationService.navigateTo(
            AppDestination.WorkWithNoteScreen,
            false
        )
    }

    fun editNote(noteData: ShortNoteInfo) {

    }
}