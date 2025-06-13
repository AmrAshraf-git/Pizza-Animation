package com.ipro.pizzaanimation.presentation

interface OnPizzaOrderClickListener {
    fun onIngredientButtonClick(chosenIngredient: Ingredient, chosenBreadIndex: Int)

    fun onBackButtonClick()

    fun onFavoriteButtonClick()

    fun onPizzaSizeButtonClick(pizzaSize: PizzaSize)

    fun onAddToCartButtonClick()

}