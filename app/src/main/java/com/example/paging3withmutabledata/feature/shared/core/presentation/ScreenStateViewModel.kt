package com.example.paging3withmutabledata.feature.shared.core.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

/**
 * ViewModel for a compose screens with a single [ScreenState] containing common helper
 * methods
 */
abstract class ScreenStateViewModel<ScreenState>(initialState: ScreenState) : ViewModel() {

    private val _screenStateStream = MutableStateFlow(initialState)
    val screenStateStream: StateFlow<ScreenState> get() = _screenStateStream

    val screenState: ScreenState
        get() = _screenStateStream.value

    protected fun setState(setter: ScreenState.() -> ScreenState) {
        _screenStateStream.value?.setter()?.let {
            _screenStateStream.value = it
        }
    }
}

@Composable
fun <SS> ScreenStateViewModel<SS>.collectScreenState(): State<SS> {
    return screenStateStream.collectAsState()
}
