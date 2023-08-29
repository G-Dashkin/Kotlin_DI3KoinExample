package com.example.kotlin_di3koinexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin_di3koinexample.Hilt1.HiltActivity1
import com.example.kotlin_di3koinexample.Hilt2.presentation.HiltActivity2
import com.example.kotlin_di3koinexample.Hilt3.step2.HiltActivity3Step2
import com.example.kotlin_di3koinexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            hilt1.setOnClickListener {
                startActivity(Intent(this@MainActivity, HiltActivity1::class.java))
            }
            hilt2.setOnClickListener {
                startActivity(Intent(this@MainActivity, HiltActivity2::class.java))
            }
            hilt3.setOnClickListener {
                startActivity(Intent(this@MainActivity, HiltActivity3Step2::class.java))
            }
        }

    }
}