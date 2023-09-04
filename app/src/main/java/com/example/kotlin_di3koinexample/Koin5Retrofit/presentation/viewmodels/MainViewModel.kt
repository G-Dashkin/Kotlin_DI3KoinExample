package com.example.kotlin_di3koinexample.Koin5Retrofit.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin_di3koinexample.Koin5Retrofit.models.Photo
import com.example.kotlin_di3koinexample.Koin5Retrofit.repository.ApiRepository
import com.example.kotlin_di3koinexample.Koin5Retrofit.utils.DataStatus
import kotlinx.coroutines.launch

class MainViewModel(private val repository: ApiRepository) : ViewModel() {

    private val _photoList = MutableLiveData<DataStatus<List<Photo.Hit>>>()
    val photoList: LiveData<DataStatus<List<Photo.Hit>>>
        get() = _photoList


    fun getPhoto(strSearchPhoto: String) = viewModelScope.launch {
        repository.getPhoto(strSearchPhoto).collect {
            _photoList.value = it
        }
    }


}