package com.ipro.pizzaanimation.presentation

import androidx.annotation.DrawableRes

data class PizzaState(
    val pizzaBreadTypes: List<PizzaBreadType> = emptyList(),
    val pizzaSize: PizzaSize = PizzaSize.MEDIUM,
    val ingredients: List<Ingredient> = emptyList(),
    val isFavorite: Boolean = false,
)

data class PizzaBreadType(
    @DrawableRes val imageRes: Int,
    val currentIngredients: List<Ingredient>,
)

enum class PizzaSize {
    SMALL,
    MEDIUM,
    LARGE
}

data class Ingredient(
    val name: String,
    @DrawableRes val imagesRes: List<Int>,
)