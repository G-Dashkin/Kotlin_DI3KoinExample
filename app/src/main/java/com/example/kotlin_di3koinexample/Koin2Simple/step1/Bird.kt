package com.example.kotlin_di3koinexample.Koin2Simple.step1

class Bird(private val fly: Fly, private val eat: Eat) {
    fun birdDesc(): String = fly.birdFly() + "\n" + eat.birdEatFood()
}