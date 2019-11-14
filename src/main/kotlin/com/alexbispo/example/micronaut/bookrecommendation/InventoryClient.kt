package com.alexbispo.example.micronaut.bookrecommendation

import io.micronaut.configuration.rabbitmq.annotation.Binding
import io.micronaut.configuration.rabbitmq.annotation.RabbitClient
import io.micronaut.configuration.rabbitmq.annotation.RabbitProperty
import io.reactivex.Maybe

@RabbitClient("micronaut")
@RabbitProperty(name = "replyTo", value = "amq.rabbitmq.reply-to")
interface InventoryClient {

    @Binding("books.inventory")
    fun stock(isbn: String): Maybe<Boolean>
}