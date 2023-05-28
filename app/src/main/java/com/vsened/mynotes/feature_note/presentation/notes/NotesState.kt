package com.vsened.mynotes.feature_note.presentation.notes

import android.provider.ContactsContract.CommonDataKinds.Note
import com.vsened.mynotes.feature_note.domain.util.NoteOrder
import com.vsened.mynotes.feature_note.domain.util.OrderType

data class NotesState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSelectionVisible: Boolean = false,

)
