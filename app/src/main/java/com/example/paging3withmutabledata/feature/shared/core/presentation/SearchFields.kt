package com.example.paging3withmutabledata.feature.shared.core.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.paging3withmutabledata.R

object SearchFields {

    @Composable
    fun Default(
        modifier: Modifier = Modifier,
        query: String,
        hint: String,
        state: SearchState = rememberSearchState(),
        onValueChange: (String) -> Unit,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .then(modifier),
            verticalAlignment = Alignment.CenterVertically
        ) {
            SearchBar {
                SearchTextField(
                    query = query,
                    hint = hint,
                    state = state,
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 8.dp),
                    onValueChange = onValueChange
                )
            }
        }
    }

    @Composable
    private fun rememberSearchState() = remember { SearchState() }

    @Stable
    class SearchState {

        var focused by mutableStateOf(false)
            private set

        val focusRequester = FocusRequester()

        fun setFocus(focused: Boolean) {
            this.focused = focused
        }
    }

    @Composable
    fun SearchBar(
        modifier: Modifier = Modifier,
        content: @Composable () -> Unit,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
                .background(ApplicationTheme.colors.backgrounds.secondary)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = null,
                tint = ApplicationTheme.colors.foregrounds.secondary,
                modifier = Modifier
                    .padding(start = 12.dp)
                    .padding(vertical = 11.dp)
            )

            Spacer(
                modifier = Modifier.width(8.dp)
            )

            content()
        }
    }

    @Composable
    private fun SearchTextField(
        query: String,
        hint: String,
        state: SearchState,
        modifier: Modifier = Modifier,
        onValueChange: (String) -> Unit,
    ) {
        val localFocusManager = LocalFocusManager.current
        Box(modifier = modifier) {
            BasicTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .onFocusChanged { state.setFocus(it.isFocused) }
                    .focusRequester(state.focusRequester),
                value = query,
                onValueChange = onValueChange,
                textStyle = ApplicationTheme.typography.paragraphs.small,
                singleLine = true,
                cursorBrush = SolidColor(ApplicationTheme.colors.foregrounds.primary),
                keyboardActions = KeyboardActions(
                    onDone = {
                        localFocusManager.clearFocus()
                    }
                )
            )

            if (query.isEmpty() && !state.focused) {
                Text(
                    text = hint,
                    style = ApplicationTheme.typography.paragraphs.small,
                    color = ApplicationTheme.colors.foregrounds.secondary.copy(alpha = 0.5f)
                )
            }
        }
    }
}
