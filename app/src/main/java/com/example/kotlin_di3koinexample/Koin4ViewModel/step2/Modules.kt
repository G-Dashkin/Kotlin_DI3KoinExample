package com.example.kotlin_di3koinexample.Koin4ViewModel.step2

import org.koin.dsl.module

val appModule = module {
    single { SchoolCourse() } // Это является синглТоном класса SchoolCourse()
    factory { Friend() } // Это является фабрикой (т.е. создается каждый раз новая инстанция класса)
    factory { Student(get(), get()) } // Так же является фабрикой, но сюда передаем методы get(), которые будут
                                      // искать необходимые зависимости для класса student
}