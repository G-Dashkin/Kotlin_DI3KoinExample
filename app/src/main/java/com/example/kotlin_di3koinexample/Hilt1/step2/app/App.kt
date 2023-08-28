package com.example.kotlin_di3koinexample.Hilt1.step2.app

import android.app.Application
import com.example.kotlin_di3koinexample.Hilt1.step2.di.appModule
import com.example.kotlin_di3koinexample.Hilt1.step2.di.dataModule
import com.example.kotlin_di3koinexample.Hilt1.step2.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

// Класс App является точкой входа в приложение и необходим для Koin
class App: Application() {

    // Метод onCreate() вызывается каждый раз, когда заново стартуется приложение
    // и в этом методе мы запускаем Koin, через startKoin и здесь указываем все модули
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG) // позволяет логировать ошибки
            androidContext(this@App) // это тот контекст, который будет указываться в data module и необходим для работы sharedPreference
            modules(listOf(appModule, domainModule, dataModule))
        }
    }
}