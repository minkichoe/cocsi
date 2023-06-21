package com.mikechoe.cocsi.domain.drink

import com.mikechoe.cocsi.domain.price.Price

class Ingredient(
    val id: Long,
    val name: String,
    val caloriePerMilligram: Double,
    val pricePerMilligram: Price,
)
