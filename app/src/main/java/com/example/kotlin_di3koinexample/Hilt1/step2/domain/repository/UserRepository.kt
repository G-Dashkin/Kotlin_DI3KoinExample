package com.example.kotlin_di3koinexample.Hilt1.step2.domain.repository

import com.example.kotlin_di3koinexample.Hilt1.step2.domain.models.SaveUserNameParam
import com.example.kotlin_di3koinexample.Hilt1.step2.domain.models.UserName

interface UserRepository {

    fun saveName(saveParam: SaveUserNameParam): Boolean

    fun getName(): UserName

}