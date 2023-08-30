package com.example.kotlin_di3koinexample.Koin1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin_di3koinexample.Koin1.step1.presentation.HiltActivity1Step1
import com.example.kotlin_di3koinexample.Koin1.step2.presentation.HiltActivity1Step2
import com.example.kotlin_di3koinexample.databinding.ActivityHilt1Binding

class HiltActivity1 : AppCompatActivity() {

    private lateinit var binding: ActivityHilt1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHilt1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            step1.setOnClickListener {
                startActivity(Intent(this@HiltActivity1, HiltActivity1Step1::class.java))
            }
            step2.setOnClickListener {
                startActivity(Intent(this@HiltActivity1, HiltActivity1Step2::class.java))
            }
        }
    }
}