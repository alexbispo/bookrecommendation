package com.alexbispo.example.micronaut.bookrecommendation

import io.micronaut.configuration.rabbitmq.annotation.Binding
import io.micronaut.configuration.rabbitmq.annotation.RabbitClient;
import io.micronaut.configuration.rabbitmq.annotation.RabbitProperty
import io.reactivex.Flowable

@RabbitClient("micronaut")
@RabbitProperty(name = "replyTo", value = "amq.rabbitmq.reply-to")
interface CatalogueClient {

    @Binding("books.catalogue")
    fun findAll(data: ByteArray?): Flowable<List<Book>>
}