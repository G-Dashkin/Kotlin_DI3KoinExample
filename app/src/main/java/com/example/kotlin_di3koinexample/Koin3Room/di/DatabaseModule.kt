package com.example.kotlin_di3koinexample.Koin3Room.di

import com.example.kotlin_di3koinexample.Koin3Room.DatabaseViewModel
import com.example.kotlin_di3koinexample.Koin3Room.repository.DatabaseRepository
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val databaseModule = module {

    single { provideDatabase(androidContext()) }
    single { provideDao(get()) }
    factory { DatabaseRepository(get()) }
    viewModel() { DatabaseViewModel(get()) }

}