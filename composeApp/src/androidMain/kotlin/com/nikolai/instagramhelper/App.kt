package com.nikolai.instagramhelper

import android.app.Application
import com.nikolai.instagramhelper.di.initKoin
import org.koin.android.ext.koin.androidContext

class App: Application() {
    override fun onCreate() {
        super.onCreate()

        initKoin {
            androidContext(applicationContext)
        }
    }
}