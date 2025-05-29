package com.nikolai.instagramhelper.di.modules

import com.nikolai.instagramhelper.features.appFeature.viewModel.AppViewModel
import com.nikolai.instagramhelper.features.notesListFeature.viewModel.NotesListViewModel
import com.nikolai.instagramhelper.features.onBoardingFeature.viewModel.OnBoardingViewModel
import com.nikolai.instagramhelper.features.workWithNoteFeature.viewModel.WorkWithFeatureViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val provideViewModelModule = module {
    viewModel { AppViewModel(get()) }
    viewModel { OnBoardingViewModel(get(), get()) }
    viewModel { NotesListViewModel(get(), get()) }
    viewModel { WorkWithFeatureViewModel(get(), get()) }
}
