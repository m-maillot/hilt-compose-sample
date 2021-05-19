package hilt.compose.feature.timer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TimerViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow(10)
    val uiState: StateFlow<Int> = _uiState

    fun start() = viewModelScope.launch {
        while (_uiState.value > 0) {
            _uiState.value = _uiState.value - 1
            delay(1000)
        }
    }
}