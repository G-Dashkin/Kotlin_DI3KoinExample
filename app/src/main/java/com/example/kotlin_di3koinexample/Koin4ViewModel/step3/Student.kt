package com.example.kotlin_di3koinexample.Koin4ViewModel.step3

// Передаем инстанции классов в конструктор
class Student(val course: SchoolCourse, val friend: Friend) {

    fun beSmart() {
        course.study()
        friend.hangout()
    }

}