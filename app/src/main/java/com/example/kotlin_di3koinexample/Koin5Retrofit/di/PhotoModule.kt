package com.example.kotlin_di3koinexample.Koin5Retrofit.di

import com.example.kotlin_di3koinexample.Koin5Retrofit.presentation.viewmodels.MainViewModel
import com.example.kotlin_di3koinexample.Koin5Retrofit.repository.ApiRepository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val photoModule = module {
    factory { ApiRepository(get()) }
    viewModel { MainViewModel(get()) }
}