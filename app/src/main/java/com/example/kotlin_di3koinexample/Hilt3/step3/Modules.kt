package com.example.kotlin_di3koinexample.Hilt3.step3

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { SchoolCourse() }
    factory { Friend() }
    factory { Student(get(), get()) }
}

// Создаем еще один модуль для вьюМодели принимающий методы get()
val viewModelModule = module {
    viewModel { MainViewModel(get(), get()) }
}