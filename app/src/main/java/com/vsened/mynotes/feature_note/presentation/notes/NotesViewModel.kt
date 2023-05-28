package com.vsened.mynotes.feature_note.presentation.notes


import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vsened.mynotes.feature_note.domain.model.Note
import com.vsened.mynotes.feature_note.domain.use_case.NoteUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
    private val noteUseCases: NoteUseCases
): ViewModel() {

    private val _state = mutableStateOf(NotesState())
    val state = _state

    private var recentlyDeletedNote: Note? = null

    fun onEvent(event: NotesEvent) {
        when (event) {
            is NotesEvent.DeleteNote -> {
                viewModelScope.launch {
                    noteUseCases.deleteNote(event.note)
                    recentlyDeletedNote = event.note
                }
            }
            is NotesEvent.Order -> {
                viewModelScope.launch {

                }
            }
            is NotesEvent.RestoreNote -> {
                TODO()
            }
            is NotesEvent.ToggleOrderSection -> {
                _state.value = state.value.copy(
                    isOrderSelectionVisible = !state.value.isOrderSelectionVisible
                )
            }
        }
    }
}