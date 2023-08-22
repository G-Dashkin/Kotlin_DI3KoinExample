package com.example.kotlin_di3koinexample.Hilt1.step1.domain.usecases

import com.example.kotlin_di3koinexample.Hilt1.step1.domain.models.SaveUserNameParam
import com.example.kotlin_di3koinexample.Hilt1.step1.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(param: SaveUserNameParam): Boolean {

        val oldUserName = userRepository.getName()

        if (oldUserName.firstName == param.name) {
            return true
        }
        val result: Boolean = userRepository.saveName(saveParam = param)
        return result
    }

}