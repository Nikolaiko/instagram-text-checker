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
        onValueChange = { }
    )
}

@Preview
@Composable
fun EmptyInputTextFieldPreview() {
    InputTextField(
        value = "",
        onValueChange = { },
        placeholder = { Text("Placeholder") }
    )
}
