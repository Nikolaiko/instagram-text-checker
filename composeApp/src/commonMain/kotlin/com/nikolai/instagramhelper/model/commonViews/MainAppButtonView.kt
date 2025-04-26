package com.nikolai.instagramhelper.model.commonViews

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nikolai.instagramhelper.model.uiScheme.redColor
import com.nikolai.instagramhelper.model.uiScheme.whiteColor
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun MainAppButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String = ""
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(
            contentColor = whiteColor,
            backgroundColor = redColor,
        ),
        content = {
            Text(
                text,
                modifier = Modifier.padding(vertical = 14.dp)
            )
        }
    )
}

@Preview
@Composable
fun TextSimpleButton() {
    Surface(modifier = Modifier.fillMaxSize()) {
        MainAppButton(onClick =  { }, text = "Some")
    }
}