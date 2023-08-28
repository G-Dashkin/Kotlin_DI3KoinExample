package com.example.kotlin_di3koinexample.Hilt1.step2.di

import com.example.kotlin_di3koinexample.Hilt1.step2.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

// Здесь описываются правила создания вьюМодели
val appModule = module {

    viewModel<MainViewModel>{
        MainViewModel(
            getUserNameUseCase = get(),
            saveUserNameUseCase = get(),
        )
    }

}