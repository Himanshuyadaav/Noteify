package com.example.notiefy.data

data class NoteData(
    val currentNote:String="",
    val notes:MutableList<String> = mutableListOf()
)