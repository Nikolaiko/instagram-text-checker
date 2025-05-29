package com.nikolai.instagramhelper.features.workWithNoteFeature.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nikolai.instagramhelper.features.workWithNoteFeature.state.WorkWithNoteViewState
import com.nikolai.instagramhelper.model.consts.TextFormatConstants
import com.nikolai.instagramhelper.model.notes.Note
import com.nikolai.instagramhelper.services.localStorageService.LocalStorageService
import com.nikolai.instagramhelper.services.navigationService.AppNavigationService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlinx.datetime.Clock

class WorkWithFeatureViewModel(
    private val navigationService: AppNavigationService,
    private val localStorageService: LocalStorageService
): ViewModel() {
    private val _stateFlow = MutableStateFlow(WorkWithNoteViewState.initialState)
    val stateFlow: StateFlow<WorkWithNoteViewState>
        get() = _stateFlow
            .asStateFlow()
            .stateIn(
                viewModelScope,
                SharingStarted.WhileSubscribed(5000),
                WorkWithNoteViewState.initialState
            )

    fun initWithNoteId(id: String?) {
        if (id == null) return

        viewModelScope.launch {
            val note = localStorageService.getNoteById(id.toInt())
            if (note != null) {
                updateState(
                    _stateFlow.value.copy(
                        currentNoteText = note.text,
                        currentNoteTitle = note.title,
                        note = note
                    )
                )
            }
        }

    }

    fun backToMainScreen() {
        navigationService.popBackStack()
    }

    fun applyChanges() {
        val selectedNote = _stateFlow.value.note
        when(selectedNote == null) {
            true -> addNewNote()
            false -> updateNote(selectedNote)
        }


    }

    fun onTitleTextChange(newTitle: String) {
        if (newTitle.length <= TextFormatConstants.maxCharsInNoteTitle) {
            updateState(
                newState = _stateFlow.value.copy(currentNoteTitle = newTitle)
            )
        }
    }

    fun onMainTextChange(newText: String) {
        val newState = _stateFlow.value.copy(
            currentNoteText = newText ,
            noteValid = isCurrentStateValid()
        )
        updateState(newState = newState)
    }

    private fun updateNote(selectedNote: Note) {
        viewModelScope.launch {
            localStorageService.updateNote(
                Note(
                    id = selectedNote.id,
                    text = _stateFlow.value.currentNoteText,
                    title = _stateFlow.value.currentNoteTitle,
                    createdDate = selectedNote.createdDate
                )
            )
            navigationService.popBackStack()
        }
    }

    private fun addNewNote() {
        viewModelScope.launch {
            localStorageService.saveNote(
                Note(
                    id = 0,
                    text = _stateFlow.value.currentNoteText,
                    title = _stateFlow.value.currentNoteTitle,
                    createdDate = Clock.System.now().epochSeconds
                )
            )
            navigationService.popBackStack()
        }
    }

    private fun isCurrentStateValid(): Boolean {
        return _stateFlow.value.currentNoteText.length <= TextFormatConstants.maxCharsInNoteText &&
                _stateFlow.value.currentNoteText.isNotEmpty() &&
                _stateFlow.value.currentNoteTitle.isNotEmpty()
    }

    private fun updateState(newState: WorkWithNoteViewState) {
        viewModelScope.launch {
            _stateFlow.emit(newState)
        }
    }
}