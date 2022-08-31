package com.example.paging3withmutabledata.feature.shared.core.presentation

import androidx.compose.material.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect

@Composable
fun DefaultSnackbar(message: String, snackbarHostState: SnackbarHostState) {
    LaunchedEffect(key1 = Unit) {
        snackbarHostState.showSnackbar(message)
    }
}
