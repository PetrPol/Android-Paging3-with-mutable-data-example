package com.example.paging3withmutabledata.feature.shared.core.presentation

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf

@Composable
fun ApplicationTheme(content: @Composable () -> Unit) {
    MaterialTheme {
        CompositionLocalProvider(
            LocalColors provides designSystemColors(),
            LocalTypography provides designSystemTypography()
        ) {
            content()
        }
    }
}

private val LocalColors = staticCompositionLocalOf { Colors() }
private val LocalTypography = staticCompositionLocalOf { Typography() }

object ApplicationTheme {

    val colors: Colors
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current

    val typography: Typography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current
}
