package com.example.notiefy.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.notiefy.viewModel.NoteViewModel

enum class NoteScreen() {
    ViewAllNotes,
    AddNotes
}

@Composable
fun NoteifyApp(
    viewModel: NoteViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
    modifier: Modifier = Modifier
) {
    val uiState by viewModel.uiState.collectAsState();
    var currentNoteText by remember {
        mutableStateOf("")
    }
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NoteScreen.ViewAllNotes.name,
    ) {
        composable(route = NoteScreen.ViewAllNotes.name) {
            ViewAllNotesScreen(
                onNextButtonClicked = { navController.navigate(NoteScreen.AddNotes.name) },
                notes = uiState.notes
            )
        }
        composable(route = NoteScreen.AddNotes.name) {
            AddNotes(
                onNextButtonClicked = {
                    viewModel.createNewNote()
                    navController.navigate(NoteScreen.ViewAllNotes.name)
                },
                onNoteTextChange = {
                    viewModel.addingNewNote(currentNoteText)
                },
                currentNoteText=currentNoteText
            )
        }
    }
}
