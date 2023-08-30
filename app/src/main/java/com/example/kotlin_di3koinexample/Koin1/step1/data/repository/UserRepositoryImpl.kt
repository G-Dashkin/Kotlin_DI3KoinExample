package com.example.kotlin_di3koinexample.Koin1.step1.data.repository

import com.example.kotlin_di3koinexample.Koin1.step1.data.storage.UserStorage
import com.example.kotlin_di3koinexample.Koin1.step1.data.storage.models.User
import com.example.kotlin_di3koinexample.Koin1.step1.domain.models.SaveUserNameParam
import com.example.kotlin_di3koinexample.Koin1.step1.domain.models.UserName
import com.example.kotlin_di3koinexample.Koin1.step1.domain.repository.UserRepository

class UserRepositoryImpl(private val userStorage: UserStorage) : UserRepository {

    override fun saveName(saveParam: SaveUserNameParam): Boolean {
        val user = mapToStorage(saveParam)
        val result = userStorage.save(user)
        return result
    }

    override fun getName(): UserName {
        val user = userStorage.get()
        return mapToDomain(user)
    }

    // Эти map-методы превращающий одну модель в другую модель.
    // В методе будет возвращаться класс UserName и приниматься класс User
    private fun mapToStorage(saveParam: SaveUserNameParam): User {
        return User(firstName = saveParam.name, lastName = "")
    }

    private fun mapToDomain(user: User): UserName {
        return UserName(firstName = user.firstName, lastName = user.lastName)
    }
}