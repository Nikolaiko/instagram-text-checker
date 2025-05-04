package com.nikolai.instagramhelper.onBoardingView

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun OnBoardingViewPreview() {
    Surface(modifier = Modifier.fillMaxSize()) {
        OnBoardingScreenView()
    }
}