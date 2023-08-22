package com.example.kotlin_di3koinexample.Hilt2.step2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin_di3koinexample.databinding.ActivityHilt2Step2Binding

class HiltActivity2Step2 : AppCompatActivity() {
    private lateinit var binding : ActivityHilt2Step2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHilt2Step2Binding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}