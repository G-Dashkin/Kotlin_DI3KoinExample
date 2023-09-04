package com.example.kotlin_di3koinexample.Koin2Simple.step2

import org.koin.dsl.module

val appModule = module {
    single { Fly() }
    factory { Eat() }
    factory { Bird(get(), get()) }
}