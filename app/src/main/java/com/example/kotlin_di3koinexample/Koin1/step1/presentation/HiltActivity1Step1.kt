package com.example.kotlin_di3koinexample.Koin1.step1.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.kotlin_di3koinexample.databinding.ActivityHilt1Step1Binding

class HiltActivity1Step1 : AppCompatActivity() {

    private lateinit var binding: ActivityHilt1Step1Binding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHilt1Step1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d("MyLog", "Activity created")

        viewModel = ViewModelProvider(this, MainViewModelFactory(this)).get(MainViewModel::class.java)

        viewModel.resultLiveData.observe(this, { text ->
            binding.dataTextView.text = text
        })


        binding.apply {

            sendButton.setOnClickListener {
                viewModel.save(dataEditText.text.toString())
            }

            receiveButton.setOnClickListener {
                viewModel.load()
            }

        }
    }
}