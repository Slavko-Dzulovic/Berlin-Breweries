package com.example.priboj.breweries2.model

import java.util.*

class Brewery(
    val id: Long,
    val name: String,
    val address: Address,
    val imageURL: String,
    val description: String? = null,
    val openingTimes: Collection<OpeningTime>? = null,
    val position: Position? = null,
    val services: Collection<Service>? = null,
    val reviews: Collection<Review>? = null
)



























