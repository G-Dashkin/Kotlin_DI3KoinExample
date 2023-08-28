package com.example.kotlin_di3koinexample.Hilt1.step2.di

import com.example.kotlin_di3koinexample.Hilt1.step2.data.repository.UserRepositoryImpl
import com.example.kotlin_di3koinexample.Hilt1.step2.data.storage.UserStorage
import com.example.kotlin_di3koinexample.Hilt1.step2.data.storage.sharedprefs.SharedPrefUserStorage
import com.example.kotlin_di3koinexample.Hilt1.step2.domain.repository.UserRepository
import org.koin.dsl.module

// Здесь мы указываем как создаются те или иные объекты
// берем userRepository из MainViewModelFactory и имплементируем здесь
val dataModule = module {

    // Здесь создаются зависимости для репозитория и стораджа
    // Если например кто то захочет получить UserStorage, то сработает, тогда Koin создаст объект
    // UserRepositoryImpl, увидит, что для его создания нужен userStorage и при помощи метода get()
    // пойдет по дургим таким же зависимостям и как только найдет конструкцию в которой есть предоставление
    // типа данных userStorage, он вызовит эту конструкцию и через метод get() она будет добавлена в
    // UserRepositoryImpl

    // то что отмечено как single создается как один объект, т.е. Storage и Repository не будут создаваться дважды
    single<UserStorage> {
        SharedPrefUserStorage(context = get())
    }

    single<UserRepository> {
        UserRepositoryImpl(userStorage = get())
    }
}