package com.example.kotlin_di3koinexample.Koin1.step1.data.storage

import com.example.kotlin_di3koinexample.Koin1.step1.data.storage.models.User

interface UserStorage {

    fun save(user: User): Boolean

    fun get(): User
}