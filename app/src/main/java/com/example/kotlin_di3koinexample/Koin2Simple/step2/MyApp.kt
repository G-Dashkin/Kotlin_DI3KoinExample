package com.example.kotlin_di3koinexample.Koin2Simple.step2

import android.app.Application
import org.koin.core.context.startKoin

class MyApp: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(appModule)
        }
    }
}