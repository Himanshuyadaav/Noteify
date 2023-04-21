package com.example.notiefy.viewModel

import androidx.lifecycle.ViewModel
import com.example.notiefy.data.NoteData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class NoteViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(NoteData())
    val uiState = _uiState.asStateFlow()

    fun createNewNote() {
        var newNotes: MutableList<String> = uiState.value.notes
        newNotes.add(uiState.value.currentNote)
        _uiState.update { it ->
            it.copy(
                notes = newNotes,
                currentNote = "",
            )
        }
    }

    fun addingNewNote(value: String){
        _uiState.update { it->
            it.copy(
                currentNote = value,
            )
        }
    }
}