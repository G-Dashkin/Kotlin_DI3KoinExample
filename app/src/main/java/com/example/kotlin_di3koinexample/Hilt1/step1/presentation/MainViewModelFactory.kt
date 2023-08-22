package com.example.kotlin_di3koinexample.Hilt1.step1.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kotlin_di3koinexample.Hilt1.step1.data.repository.UserRepositoryImpl
import com.example.kotlin_di3koinexample.Hilt1.step1.data.storage.sharedprefs.SharedPrefUserStorage
import com.example.kotlin_di3koinexample.Hilt1.step1.domain.usecases.GetUserNameUseCase
import com.example.kotlin_di3koinexample.Hilt1.step1.domain.usecases.SaveUserNameUseCase

class MainViewModelFactory(context: Context) : ViewModelProvider.Factory {

    private val userRepository by lazy(LazyThreadSafetyMode.NONE) {
        UserRepositoryImpl(userStorage = SharedPrefUserStorage(context = context))
    }
    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        GetUserNameUseCase(userRepository = userRepository)
    }
    private val saveUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        SaveUserNameUseCase(userRepository = userRepository)
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(
            getUserNameUseCase = getUserNameUseCase,
            saveUserNameUseCase = saveUserNameUseCase
        ) as T
    }

}