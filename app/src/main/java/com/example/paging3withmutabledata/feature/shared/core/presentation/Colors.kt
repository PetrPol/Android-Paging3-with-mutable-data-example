package com.example.paging3withmutabledata.feature.shared.core.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
data class Colors(
    val foregrounds: Foregrounds,
    val backgrounds: Backgrounds,
) {

    constructor() : this(Foregrounds(), Backgrounds())

    @Immutable
    data class Foregrounds(
        val primary: Color,
        val secondary: Color,
        val tertiary: Color,
    ) {

        constructor() : this(
            primary = Color.Unspecified,
            secondary = Color.Unspecified,
            tertiary = Color.Unspecified,
        )
    }

    @Immutable
    data class Backgrounds(
        val primary: Color,
        val secondary: Color,
    ) {

        constructor() : this(
            primary = Color.Unspecified,
            secondary = Color.Unspecified,
        )
    }
}

@Composable
fun designSystemColors(): Colors {
    return Colors(
        foregrounds = Colors.Foregrounds(
            primary = Color(0xFF191919),
            secondary = Color(0xFF6D6D6D),
            tertiary = Color(0xFFEE242C),
        ),
        backgrounds = Colors.Backgrounds(
            primary = Color(0xFFFFFFFF),
            secondary = Color(0xBAEEEEEE),
        )
    )
}
