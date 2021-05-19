package hilt.compose.feature.counter

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun CounterScreen(counterViewModel: CounterViewModel = viewModel(), onDone: () -> Unit) {
    val state = counterViewModel.uiState.collectAsState().value

    if (state == 10) {
        onDone()
    }
    Column {
        Text("Counter: $state")
        TextButton(onClick = { counterViewModel.increase() }) {
            Text("Increase counter")
        }
    }
}