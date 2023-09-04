package com.example.kotlin_di3koinexample.Koin4ViewModel.step2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin_di3koinexample.databinding.ActivityHilt4Step2Binding
import org.koin.android.ext.android.get

class HiltActivity4Step2 : AppCompatActivity() {

    private lateinit var binding: ActivityHilt4Step2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHilt4Step2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Здесь создаем две инстанции класса Student() без необходимости передачи в них параметров
        // и вызываем метод bbeSmart()

        val student1 = get<Student>()
        student1.beSmart()

        val student2 = get<Student>()
        student2.beSmart()

        // Можно запустить приложение через дебагер и помотерть что получается
        // Класс Course() имеет один и тот же id, так как это синглтон, а Friend() имеет разный id
    }
}