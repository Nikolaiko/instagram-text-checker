package com.nikolai.instagramhelper.features.notesListFeature.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.nikolai.instagramhelper.features.notesListFeature.state.NotesListViewState
import com.nikolai.instagramhelper.features.notesListFeature.view.subviews.SingleNoteItemView
import com.nikolai.instagramhelper.features.notesListFeature.viewModel.NotesListViewModel
import com.nikolai.instagramhelper.model.uiScheme.blackColor
import instagramhelper.composeapp.generated.resources.Poppins_Bold
import instagramhelper.composeapp.generated.resources.Res
import instagramhelper.composeapp.generated.resources.new_note_button_description
import instagramhelper.composeapp.generated.resources.notes_list_title
import instagramhelper.composeapp.generated.resources.plus_button
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun NotesListView(viewModel: NotesListViewModel = koinViewModel()) {

    val uiState = viewModel.stateFlow.collectAsState(NotesListViewState.initialState)

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = 36.dp)) {

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 18.dp, bottom = 42.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically) {

            Text(stringResource(Res.string.notes_list_title),
                fontSize = 24.sp,
                fontFamily = FontFamily(Font(Res.font.Poppins_Bold)),
                fontWeight = FontWeight.Bold,
                color = blackColor,
                textAlign = TextAlign.Start)

            Image(painter = painterResource(Res.drawable.plus_button),
                contentDescription = stringResource(Res.string.new_note_button_description),
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(56.dp)
                    .clickable { viewModel.createNewNote() }
            )
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            items(uiState.value.notesList) {
                SingleNoteItemView(it, onClick = { selectedId ->
                    viewModel.editNote(selectedId)
                })
            }
        }
    }
}