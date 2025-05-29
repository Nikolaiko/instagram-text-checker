package com.nikolai.instagramhelper.features.workWithNoteFeature.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nikolai.instagramhelper.commonViews.InputTextField
import com.nikolai.instagramhelper.commonViews.MainAppButton
import com.nikolai.instagramhelper.features.workWithNoteFeature.state.WorkWithNoteViewState
import com.nikolai.instagramhelper.features.workWithNoteFeature.viewModel.WorkWithFeatureViewModel
import com.nikolai.instagramhelper.model.consts.TextFormatConstants
import com.nikolai.instagramhelper.model.uiScheme.blackColor
import instagramhelper.composeapp.generated.resources.*
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun WorkWithNoteView(viewModel: WorkWithFeatureViewModel = koinViewModel()) {

    val uiState = viewModel.stateFlow.collectAsState(WorkWithNoteViewState.initialState)

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = 36.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        Text(stringResource(Res.string.work_with_note_title),
            fontSize = 24.sp,
            fontFamily = FontFamily(Font(Res.font.Poppins_Bold)),
            fontWeight = FontWeight.Bold,
            color = blackColor,
            textAlign = TextAlign.Start)

        InputTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = uiState.value.currentNoteTitle,
            singleLine = true,
            onValueChange = viewModel::onTitleTextChange,
            placeholder = { Text(
                stringResource(Res.string.note_title_placeholder)
            ) },
            maxChar = TextFormatConstants.maxCharsInNoteTitle
        )

        InputTextField(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(fraction = 0.7f),
            value = uiState.value.currentNoteText,
            onValueChange = viewModel::onMainTextChange,
            placeholder = { Text(
                stringResource(Res.string.note_text_placeholder)
            ) },
            maxChar = TextFormatConstants.maxCharsInNoteText,
            isError = !uiState.value.noteValid
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            MainAppButton(
                onClick =  { viewModel.backToMainScreen() },
                text = stringResource(Res.string.cancel_button_title)
            )

            MainAppButton(
                onClick =  { viewModel.applyChanges() },
                enabled = uiState.value.noteValid,
                text = stringResource(Res.string.apply_button_title)
            )
        }
    }
}