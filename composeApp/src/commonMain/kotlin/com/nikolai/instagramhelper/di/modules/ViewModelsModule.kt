package com.nikolai.instagramhelper.di.modules

import com.nikolai.instagramhelper.appFeature.viewModel.AppViewModel
import com.nikolai.instagramhelper.onBoardingFeature.viewModel.OnBoardingViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val provideViewModelModule = module {
    viewModel { AppViewModel(get()) }
    viewModel { OnBoardingViewModel(get()) }
}