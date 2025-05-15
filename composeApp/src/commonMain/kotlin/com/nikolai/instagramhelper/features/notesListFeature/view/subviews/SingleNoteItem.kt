package com.nikolai.instagramhelper.features.notesListFeature.view.subviews

import androidx.compose.foundation.content.MediaType.Companion.Text
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.nikolai.instagramhelper.model.consts.noteCreateDateFormat
import com.nikolai.instagramhelper.model.notes.ShortNoteInfo
import com.nikolai.instagramhelper.model.uiScheme.blackColor
import instagramhelper.composeapp.generated.resources.Poppins_Bold
import instagramhelper.composeapp.generated.resources.Poppins_Regular
import instagramhelper.composeapp.generated.resources.Res
import kotlinx.datetime.Instant
import kotlinx.datetime.format
import kotlinx.datetime.format.DateTimeFormat
import org.jetbrains.compose.resources.Font

@Composable
fun SingleNoteItemView(item: ShortNoteInfo) {
    val instant = Instant.fromEpochSeconds(item.createdDate)

    Row(modifier = Modifier
        .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween) {

        Text(item.title,
            fontSize = 24.sp,
            fontFamily = FontFamily(Font(Res.font.Poppins_Regular)),
            fontWeight = FontWeight.Normal,
            color = blackColor,
            textAlign = TextAlign.Start)

        Text(instant.format(noteCreateDateFormat),
            fontSize = 24.sp,
            fontFamily = FontFamily(Font(Res.font.Poppins_Regular)),
            fontWeight = FontWeight.Normal,
            color = blackColor,
            textAlign = TextAlign.End)
    }
}