package com.nikolai.instagramhelper.commonViews

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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nikolai.instagramhelper.model.uiScheme.redColor
import com.nikolai.instagramhelper.model.uiScheme.whiteColor
import instagramhelper.composeapp.generated.resources.Poppins_Bold
import instagramhelper.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.Font

@Composable
fun MainAppButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String = "",
    enabled: Boolean = true
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        enabled = enabled,
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(
            contentColor = whiteColor,
            backgroundColor = redColor,
        ),
        content = {
            Text(
                text,
                fontSize = 20.sp,
                fontFamily = FontFamily(Font(Res.font.Poppins_Bold)),
                fontWeight = FontWeight.Bold
            )
        }
    )
}

