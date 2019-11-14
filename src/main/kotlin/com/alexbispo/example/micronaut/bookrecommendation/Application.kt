package com.alexbispo.example.micronaut.bookrecommendation

import io.micronaut.runtime.Micronaut

object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
                .packages("com.alexbispo.example.micronaut.bookrecommendation")
                .mainClass(Application.javaClass)
                .start()
    }
}