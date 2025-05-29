package com.nikolai.instagramhelper.commonViews

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun InputTextField(
    value: String,
    onValueChange: (String) -> Unit,
    maxChar: Int,
    placeholder: @Composable (() -> Unit)? = null,
    singleLine: Boolean = false,
    isError: Boolean = false,
    modifier: Modifier = Modifier
) {
    Column {
        OutlinedTextField(
            modifier = modifier,
            value = value,
            singleLine = singleLine,
            onValueChange = onValueChange,
            placeholder = placeholder,
            isError = isError,
        )
        Text(
            text = "${value.length} / $maxChar",
            textAlign = TextAlign.End,
            style = MaterialTheme.typography.caption,
            modifier = Modifier.fillMaxWidth().padding(end = 16.dp)
        )
    }
}