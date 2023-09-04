package com.example.kotlin_di3koinexample.Koin2Simple.step1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin_di3koinexample.databinding.ActivityHilt2Step1Binding

class HiltActivity2Step1 : AppCompatActivity() {
    private lateinit var binding: ActivityHilt2Step1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHilt2Step1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val fly = Fly()
        val eat = Eat()
        val bird = Bird(fly, eat)

        binding.tvText.text = bird.birdDesc()
    }
}