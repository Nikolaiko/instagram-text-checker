package com.nikolai.instagramhelper.commonViewsPreviews

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.nikolai.instagramhelper.commonViews.InputTextField
import org.jetbrains.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun InputTextFieldPreview() {
    InputTextField(
        value = "Some text",
        onValueChange = { },
        maxChar = 4
    )
}

@Preview
@Composable
fun EmptyInputTextFieldPreview() {
    InputTextField(
        value = "",
        onValueChange = { },
        placeholder = { Text("Placeholder") },
        maxChar = 4
    )
}

@Preview
@Composable
fun ErrorInputTextFieldPreview() {
    InputTextField(
        value = "",
        onValueChange = { },
        placeholder = { Text("Placeholder") },
        maxChar = 4,
        isError = true
    )
}
