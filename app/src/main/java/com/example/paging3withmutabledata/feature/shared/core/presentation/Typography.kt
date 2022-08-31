package com.example.paging3withmutabledata.feature.shared.core.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Immutable
data class Typography(
    val headlines: Headlines,
    val buttons: Buttons,
    val paragraphs: Paragraphs,
) {

    constructor() : this(Headlines(), Buttons(), Paragraphs())

    @Immutable
    data class Headlines(
        val h1: TextStyle,
        val h2: TextStyle,
    ) {

        constructor() : this(
            h1 = TextStyle.Default,
            h2 = TextStyle.Default,
        )
    }

    @Immutable
    data class Paragraphs(
        val small: TextStyle,
        val medium: TextStyle,
        val large: TextStyle,
    ) {

        constructor() : this(
            small = TextStyle.Default,
            medium = TextStyle.Default,
            large = TextStyle.Default,
        )
    }

    @Immutable
    data class Buttons(
        val primary: TextStyle,
    ) {

        constructor() : this(
            primary = TextStyle.Default,
        )
    }
}

@Composable
fun designSystemTypography(): Typography {
    return Typography(
        headlines = Typography.Headlines(
            h1 = TextStyle(fontSize = 30.sp, fontWeight = FontWeight.Bold).withTypographyDefaults(),
            h2 = TextStyle(fontSize = 23.sp, fontWeight = FontWeight.Bold).withTypographyDefaults(),
        ),
        buttons = Typography.Buttons(
            primary = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.SemiBold, lineHeight = 24.sp).withTypographyDefaults(),
        ),
        paragraphs = Typography.Paragraphs(
            large = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Medium, lineHeight = 20.sp).withTypographyDefaults(),
            medium = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Normal, lineHeight = 22.sp).withTypographyDefaults(),
            small = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Medium, lineHeight = 20.sp).withTypographyDefaults(),
        )
    )
}

@Composable
private fun TextStyle.withTypographyDefaults() = copy(
    color = ApplicationTheme.colors.foregrounds.primary
)
