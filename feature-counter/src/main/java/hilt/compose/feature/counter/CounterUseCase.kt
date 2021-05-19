package hilt.compose.feature.counter

import javax.inject.Inject

class CounterUseCase @Inject constructor() {

    fun run(currentValue: Int) = currentValue + 1
}