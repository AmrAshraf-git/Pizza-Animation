package com.ipro.pizzaanimation.di

import com.ipro.pizzaanimation.presentation.PizzaViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { PizzaViewModel() }
}