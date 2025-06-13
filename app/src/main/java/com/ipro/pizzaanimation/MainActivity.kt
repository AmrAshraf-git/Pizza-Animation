package com.ipro.pizzaanimation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import org.koin.androidx.viewmodel.ext.android.viewModel
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ipro.pizzaanimation.presentation.PizzaViewModel
import com.ipro.pizzaanimation.presentation.screen.order.PizzaScreen
import com.ipro.pizzaanimation.ui.theme.PizzaAnimationTheme

class MainActivity : ComponentActivity() {
    private val viewModel: PizzaViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PizzaAnimationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PizzaScreen(modifier = Modifier.padding(innerPadding),
                        state = viewModel.state.collectAsStateWithLifecycle().value,
                        interactionHandler = viewModel)
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PizzaAnimationTheme {

    }
}