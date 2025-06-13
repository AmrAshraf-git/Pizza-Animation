package com.ipro.pizzaanimation.presentation

import androidx.lifecycle.ViewModel
import com.ipro.pizzaanimation.data.datasource.DummyDataSource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class PizzaViewModel : ViewModel(), OnPizzaOrderClickListener {

    private val _state = MutableStateFlow(PizzaState())
    val state = _state.asStateFlow()

    init {
        loadInitialState()
    }

    private fun loadInitialState() {
        _state.update { currentState ->
            currentState.copy(
                ingredients = DummyDataSource.ingredient,
                pizzaBreadTypes = DummyDataSource.pizzaBreadTypesRes.map {
                    PizzaBreadType(
                        imageRes = it,
                        currentIngredients = emptyList()
                    )
                }
            )
        }
    }

    override fun onPizzaSizeButtonClick(pizzaSize: PizzaSize) {
        _state.update {currentState ->
            currentState.copy(
                pizzaSize = pizzaSize
            )
        }
    }

    override fun onIngredientButtonClick(chosenIngredient: Ingredient, chosenBreadIndex: Int) {
        _state.update { currentState ->
            if (currentState.pizzaBreadTypes[chosenBreadIndex].currentIngredients.find { it.name == chosenIngredient.name } != null) {
                currentState.copy(
                    pizzaBreadTypes = currentState.pizzaBreadTypes.mapIndexed { index, pizzaType ->
                        if (index == chosenBreadIndex) {
                            pizzaType.copy(
                                currentIngredients = pizzaType.currentIngredients.filter { it.name != chosenIngredient.name }
                            )
                        } else {
                            pizzaType
                        }
                    }
                )
            } else {
                currentState.copy(
                    pizzaBreadTypes = currentState.pizzaBreadTypes.mapIndexed { index, pizzaType ->
                        if (index == chosenBreadIndex) {
                            pizzaType.copy(
                                currentIngredients = pizzaType.currentIngredients + chosenIngredient
                            )
                        } else {
                            pizzaType
                        }
                    }
                )
            }
        }
    }

    override fun onFavoriteButtonClick() {
        /*TODO: Not required in task */
    }

    override fun onAddToCartButtonClick() {
        /*TODO: Not required in task */
    }

    override fun onBackButtonClick() {
        /*TODO: Not required in task */
    }
}