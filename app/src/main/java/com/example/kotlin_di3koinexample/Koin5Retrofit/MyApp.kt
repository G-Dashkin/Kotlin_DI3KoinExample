package com.example.kotlin_di3koinexample.Koin5Retrofit

import android.app.Application
import com.example.kotlin_di3koinexample.Koin5Retrofit.di.apiModule
import com.example.kotlin_di3koinexample.Koin5Retrofit.di.photoModule
import org.koin.core.context.startKoin

class MyApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            // Retrofit
            modules(apiModule, photoModule)
        }
    }
}