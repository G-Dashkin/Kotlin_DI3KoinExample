package com.example.kotlin_di3koinexample.Koin4ViewModel.step1

class Student() {

    val course: SchoolCourse = SchoolCourse()
    val friend: Friend = Friend()

    fun beSmart() {
        course.study()
        friend.hangout()
    }


}