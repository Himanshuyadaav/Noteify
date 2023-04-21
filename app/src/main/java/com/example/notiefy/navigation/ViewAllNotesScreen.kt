package com.example.notiefy.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.example.notiefy.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ViewAllNotesScreen(
    onNextButtonClicked: () -> Unit = {},
    notes:List<String>,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = stringResource(id = R.string.Noteify)) },
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color(red=176, green = 218,blue=255)),
                modifier = modifier
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = onNextButtonClicked,
                containerColor= Color(red=102, green = 255,blue=102),
                shape = MaterialTheme.shapes.small.copy(CornerSize(percent = 50)),
            ) {
                Icon(
                    Icons.Filled.Create, contentDescription = stringResource(
                    id = R.string.CreateNote
                )
                )
            }
        },
        content = {padding ->
            LazyColumn(modifier=Modifier.padding(padding)){
                items(notes){
                        note->
                    Text(text="$note")
                }
            }
        }
    )
}