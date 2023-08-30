package com.example.kotlin_di3koinexample.Koin1.step2.di

import com.example.kotlin_di3koinexample.Koin1.step2.domain.usecases.GetUserNameUseCase
import com.example.kotlin_di3koinexample.Koin1.step2.domain.usecases.SaveUserNameUseCase
import org.koin.dsl.module

// В Domain модуле мы делае тоже саме, что и в data модуле
// берем userRepository из MainViewModelFactory
val domainModule = module {

    factory<GetUserNameUseCase> {
        GetUserNameUseCase(userRepository = get())
    }

    factory<SaveUserNameUseCase> {
        SaveUserNameUseCase(userRepository = get())
    }

}