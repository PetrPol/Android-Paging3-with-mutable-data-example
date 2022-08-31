package com.example.paging3withmutabledata.feature.shared.core.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun NextPageProgressView() {
    ScreenProgressView(
        modifier = Modifier
            .wrapContentHeight()
            .padding(vertical = 16.dp)
    )
}

@Composable
fun ScreenProgressView(
    modifier: Modifier = Modifier,
) {
    Box(
        Modifier
            .fillMaxSize()
            .background(ApplicationTheme.colors.backgrounds.primary.copy(0.6f))
            .clickable(enabled = false) {}
            .then(modifier),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier.size(32.dp),
            color = ApplicationTheme.colors.foregrounds.primary
        )
    }
}
