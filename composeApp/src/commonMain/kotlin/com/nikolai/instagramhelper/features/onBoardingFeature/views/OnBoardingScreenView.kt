package com.nikolai.instagramhelper.features.onBoardingFeature.views

import androidx.compose.foundation.background
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
import com.nikolai.instagramhelper.commonViews.MainAppButton
import com.nikolai.instagramhelper.features.onBoardingFeature.state.OnBoardingScreenState
import com.nikolai.instagramhelper.features.onBoardingFeature.viewModel.OnBoardingViewModel
import com.nikolai.instagramhelper.model.uiScheme.blackColor
import com.nikolai.instagramhelper.model.uiScheme.whiteColor
import instagramhelper.composeapp.generated.resources.*
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun OnBoardingScreenView(viewModel: OnBoardingViewModel = koinViewModel() ) {

    val uiState = viewModel.stateFlow.collectAsState(OnBoardingScreenState.initialState)

    Box(modifier = Modifier
        .padding(horizontal = 38.dp)
        .fillMaxSize()
        .background(whiteColor)) {

        Column(modifier = Modifier
            .fillMaxHeight(),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                stringResource(Res.string.on_boarding_title),
                modifier = Modifier.fillMaxWidth(),
                fontSize = 30.sp,
                fontFamily = FontFamily(Font(Res.font.Poppins_Bold)),
                fontWeight = FontWeight.Bold,
                color = blackColor,
                textAlign = TextAlign.Center
            )
            Text(
                stringResource(Res.string.on_boarding_subtitle),
                fontSize = 20.sp,
                fontFamily = FontFamily(Font(Res.font.Poppins_Regular)),
                fontWeight = FontWeight.Normal,
                color = blackColor,
                textAlign = TextAlign.Center
            )
        }
        Column(modifier = Modifier
            .fillMaxHeight()
            .padding(bottom = 80.dp),
            verticalArrangement = Arrangement.Bottom
        ) {
            MainAppButton(
                modifier = Modifier.fillMaxWidth(),
                onClick =  { viewModel.finishOnBoarding() },
                text = "Close"
            )
        }
    }
}