package com.nikolai.instagramhelper.commonViewsPreviews

import androidx.compose.runtime.Composable
import com.nikolai.instagramhelper.commonViews.MainAppButton
import org.jetbrains.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun MainAppButtonPreview() {
    MainAppButton(
        onClick = { },
        text = "Example text"
    )
}

@Preview
@Composable
fun MainAppButtonDisabledPreview() {
    MainAppButton(
        onClick = { },
        text = "Example text",
        enabled = false
    )
}
