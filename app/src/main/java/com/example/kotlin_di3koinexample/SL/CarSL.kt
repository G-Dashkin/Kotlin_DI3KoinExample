package com.example.kotlin_di3koinexample.SL

class CarSL {
    private val engine = ServiceLocator.getEngine()

    fun start() {
        engine.start()
    }
}