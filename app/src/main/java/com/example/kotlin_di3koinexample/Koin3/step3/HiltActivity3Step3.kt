package com.example.kotlin_di3koinexample.Koin3.step3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin_di3koinexample.databinding.ActivityHiltActivity3Step3Binding
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject

// Тот же самый пример, но с использование ViewModel
class HiltActivity3Step3 : AppCompatActivity() {

    private lateinit var binding: ActivityHiltActivity3Step3Binding

    // Создаем объект ViewModel через метод inject<>()
    val viewModel by inject<MainViewModel>()

    // Так же для примера через метод inject<>() можно создавать и инстанции других объектов
    val student2 by inject<Student>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHiltActivity3Step3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val student1 = get<Student>()
        student1.beSmart()

        // И также вызваем метод beSmart() у иннстанции класса
        student2.beSmart()

        // И вызываем метод .performAction() у вьюМодели
        viewModel.performAction()

    }
}