package com.mikechoe.cocsi.domain.drink

class Recipe(
    val id: Long,
    val ingredients: List<Ingredient>,
    val steps: List<Step>,
)
