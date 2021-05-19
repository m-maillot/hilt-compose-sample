package hilt.compose.feature.timer

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun TimerScreen(timerViewModel: TimerViewModel = viewModel(), onDone: () -> Unit) {
    val state = timerViewModel.uiState.collectAsState().value

    if (state == 0) {
        onDone()
    }
    Column {
        Text("Timer: $state")
        TextButton(onClick = { timerViewModel.start() }) {
            Text("Start timer")
        }
    }
}