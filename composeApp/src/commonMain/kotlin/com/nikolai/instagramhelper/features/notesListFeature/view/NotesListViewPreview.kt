package com.nikolai.instagramhelper.features.notesListFeature.view

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.nikolai.instagramhelper.di.modules.platformModule
import com.nikolai.instagramhelper.di.modules.provideServicesModule
import com.nikolai.instagramhelper.di.modules.provideViewModelModule
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication
import org.koin.mp.KoinPlatformTools

@Preview
@Composable
fun NotesListViewPreview() {
    if (KoinPlatformTools.defaultContext().getOrNull() == null) {
        KoinApplication(application = {
            modules(platformModule(),
                provideServicesModule,
                provideViewModelModule
            )
        }) {
            Surface(modifier = Modifier.fillMaxSize()) {
                NotesListView()
            }
        }
    } else {
        Surface(modifier = Modifier.fillMaxSize()) {
            NotesListView()
        }
    }

}