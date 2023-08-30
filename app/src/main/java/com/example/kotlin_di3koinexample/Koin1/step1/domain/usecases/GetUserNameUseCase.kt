package com.example.kotlin_di3koinexample.Koin1.step1.domain.usecases

import com.example.kotlin_di3koinexample.Koin1.step1.domain.models.UserName
import com.example.kotlin_di3koinexample.Koin1.step1.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(): UserName {
        return userRepository.getName()
    }
}