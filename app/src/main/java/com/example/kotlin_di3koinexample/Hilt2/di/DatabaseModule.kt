package com.example.kotlin_di3koinexample.Hilt2.di

import com.example.kotlin_di3koinexample.Hilt2.DatabaseViewModel
import com.example.kotlin_di3koinexample.Hilt2.repository.DatabaseRepository
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val databaseModule = module {

    single { provideDatabase(androidContext()) }
    single { provideDao(get()) }
    factory { DatabaseRepository(get()) }
    viewModel() { DatabaseViewModel(get()) }

}