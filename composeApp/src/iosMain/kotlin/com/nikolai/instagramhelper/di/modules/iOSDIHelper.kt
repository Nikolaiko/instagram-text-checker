package com.nikolai.instagramhelper.di.modules

import com.nikolai.instagramhelper.services.localStorageService.LocalStorageService
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class iOSDIHelper: KoinComponent {
    private val notesRepository: LocalStorageService by inject()

    fun getNotesRepository(): LocalStorageService = notesRepository
}