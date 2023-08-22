package com.example.kotlin_di3koinexample.Hilt2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin_di3koinexample.Hilt1.step1.presentation.HiltActivity1Step1
import com.example.kotlin_di3koinexample.Hilt1.step2.presentation.HiltActivity1Step2
import com.example.kotlin_di3koinexample.Hilt2.step2.HiltActivity2Step2
import com.example.kotlin_di3koinexample.databinding.ActivityHilt2Binding

class HiltActivity2 : AppCompatActivity() {
    private lateinit var binding : ActivityHilt2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHilt2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
//            step1.setOnClickListener {
//                startActivity(Intent(this@HiltActivity2, HiltActivity2Step1::class.java))
//            }
            step2.setOnClickListener {
                startActivity(Intent(this@HiltActivity2, HiltActivity2Step2::class.java))
            }
        }

    }
}