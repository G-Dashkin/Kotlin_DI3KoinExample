package com.example.kotlin_di3koinexample.Koin4ViewModel.step3

import android.util.Log
import androidx.lifecycle.ViewModel

class MainViewModel(val course: SchoolCourse, val friend: Friend): ViewModel() {

    fun performAction() {
        Log.d("MyLog", "fun performAction() in ViewModel")
    }

}