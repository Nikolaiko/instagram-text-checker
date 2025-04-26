package com.nikolai.instagramhelper

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.unit.dp
import com.nikolai.instagramhelper.model.commonViews.MainAppButton
import com.nikolai.instagramhelper.model.uiScheme.whiteColor

@Composable
fun OnBoardingScreenView() {
    Column(
        modifier = Modifier
            .padding(horizontal = 38.dp)
            .fillMaxSize()
            .background(whiteColor),
        verticalArrangement = Arrangement.Center
    ) {
        Text("Instagram helper",)
        Text("Desc")
        MainAppButton(
            modifier = Modifier.fillMaxWidth(),
            onClick =  { },
            text = "Close"
        )
    }
}

// Конфигурации сборки настроить для Intellij
// Импортировать шрифты
// Первые UI
// Compose Mulitplatform Preview