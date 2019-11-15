package com.alexbispo.example.micronaut.bookrecommendation

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.reactivex.Flowable
import org.intellij.lang.annotations.Flow
import javax.inject.Inject

@Controller("/books")
class BookController {

    @Inject
    lateinit var catalogueClient: CatalogueClient

    @Inject
    lateinit var inventoryClient: InventoryClient

    @Get("/")
    fun index(): Flowable<BookRecommendation> {
        return catalogueClient.findAll(null)
                .flatMap{ Flowable.fromIterable(it) }
                .map { BookRecommendation(it.name) }
    }
}