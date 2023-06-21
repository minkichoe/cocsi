package com.cocsi.domain.drink

import kotlin.time.Duration

class RecipeStep(
    val id: Long,
    val ingredients: List<Ingredient>,
    val duration: Duration,
    val action: Action,
)
