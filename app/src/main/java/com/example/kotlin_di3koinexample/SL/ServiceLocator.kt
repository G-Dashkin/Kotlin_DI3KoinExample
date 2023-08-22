package com.example.kotlin_di3koinexample.SL

object ServiceLocator {
    fun getEngine(): Engine = Engine()
}