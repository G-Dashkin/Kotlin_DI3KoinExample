package com.example.kotlin_di3koinexample.Koin5Retrofit.repository

import android.util.Log
import com.example.kotlin_di3koinexample.Koin5Retrofit.api.ApiServices
import com.example.kotlin_di3koinexample.Koin5Retrofit.utils.DataStatus
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class ApiRepository(
    private val apiServices: ApiServices,
) {
    suspend fun getPhoto(strSearchPhoto: String) = flow {
        Log.d("MyLog", DataStatus.toString())
        emit(DataStatus.loading())
        val result = apiServices.getPhoto(strSearchPhoto)
        Log.d("MyLog", result.code().toString())
        when (result.code()) {
            200 -> emit(DataStatus.success(result.body()?.hits))
            400 -> emit(DataStatus.error(result.message()))
            500 -> emit(DataStatus.error(result.message()))
        }
    }.catch {
        Log.d("MyLog", it.message.toString())
        emit(DataStatus.error(it.message.toString()))
        }.flowOn(Dispatchers.IO)
}