package com.nikolai.instagramhelper.di

import com.nikolai.instagramhelper.di.modules.platformModule
import com.nikolai.instagramhelper.di.modules.provideServicesModule
import com.nikolai.instagramhelper.di.modules.provideTestModule
import com.nikolai.instagramhelper.di.modules.provideViewModelModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)

        modules(
            platformModule(),
            provideViewModelModule,
            provideServicesModule
            //provideTestModule
        )
    }
}
