package com.example.kotlin_di3koinexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin_di3koinexample.Koin1.HiltActivity1
import com.example.kotlin_di3koinexample.Koin2Simple.HiltActivity2
import com.example.kotlin_di3koinexample.Koin3Room.presentation.HiltActivity3
import com.example.kotlin_di3koinexample.Koin4ViewModel.step2.HiltActivity4Step2
import com.example.kotlin_di3koinexample.Koin4ViewModel.step3.HiltActivity4Step3
import com.example.kotlin_di3koinexample.Koin5Retrofit.presentation.ui.HiltActivity5
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
                startActivity(Intent(this@MainActivity, HiltActivity3::class.java))
            }
            hilt42.setOnClickListener {
                startActivity(Intent(this@MainActivity, HiltActivity4Step2::class.java))
            }
            hilt43.setOnClickListener {
                startActivity(Intent(this@MainActivity, HiltActivity4Step3::class.java))
            }
            hilt5.setOnClickListener {
                startActivity(Intent(this@MainActivity, HiltActivity5::class.java))
            }
        }

    }
}