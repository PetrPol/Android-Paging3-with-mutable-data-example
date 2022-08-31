package com.example.paging3withmutabledata.feature.shared.core.presentation

import androidx.compose.material.SnackbarHostState
import androidx.compose.runtime.Composable

@Composable
fun BaseHandleOfErrors(exception: Throwable, snackbarHostState: SnackbarHostState) {
    DefaultSnackbar(exception.message ?: "Unknown error", snackbarHostState)
}
