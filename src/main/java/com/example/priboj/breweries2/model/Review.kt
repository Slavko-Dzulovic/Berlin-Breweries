package com.example.priboj.breweries2.model

import java.util.*

class Review(
    val rating: Int,
    val description: String,
    val customer: Customer,
    val date: Date,
    val reviewName: String
)