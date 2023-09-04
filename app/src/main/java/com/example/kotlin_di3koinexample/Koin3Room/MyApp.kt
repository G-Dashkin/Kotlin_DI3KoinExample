package com.example.kotlin_di3koinexample.Koin3Room

import android.app.Application
import com.example.kotlin_di3koinexample.Koin3Room.di.databaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApp)
            modules(databaseModule)
        }
    }
}