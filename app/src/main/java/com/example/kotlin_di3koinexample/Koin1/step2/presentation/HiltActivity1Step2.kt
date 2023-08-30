package com.example.kotlin_di3koinexample.Koin1.step2.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.kotlin_di3koinexample.databinding.ActivityHilt1Step2Binding
import org.koin.androidx.viewmodel.ext.android.viewModel

class HiltActivity1Step2 : AppCompatActivity() {

    // Класс MainViewModel мы удалили, так как он нам больше не нужен
    // Вместо него вызваем by viewModel<>() из org.koin.androidx.viewmodel.ext.android.viewModel

    private lateinit var binding: ActivityHilt1Step2Binding
    private val viewModel by viewModel<MainViewModel>()

    // т.е. функция by viewModel<MainViewModel>() после ее вызова проходится по всем di модулям и
    // ищит правила создания вьюМодели
    // Правила для создания вьюМодели мы пишем в AppModule

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHilt1Step2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d("MyLog", "Activity created")

        // это строка нам уже не нужна, все создание вьюМодели уже произошло
//        viewModel = ViewModelProvider(this, MainViewModelFactory(this)).get(MainViewModel::class.java)

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