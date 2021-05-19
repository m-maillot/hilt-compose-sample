package hilt.compose.feature.counter

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class CounterViewModel @Inject constructor(
    private val counterUseCase: CounterUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(0)
    val uiState: StateFlow<Int> = _uiState

    fun increase() {
        _uiState.value = counterUseCase.run(_uiState.value)
    }
}