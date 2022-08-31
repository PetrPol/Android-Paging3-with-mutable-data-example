package com.example.paging3withmutabledata.feature.shared.core.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems

@Composable
fun <T : Any> PaginatedLazyColumn(
    modifier: Modifier = Modifier,
    lazyListState: LazyListState = rememberLazyListState(),
    items: LazyPagingItems<T>,
    itemSpacing: Dp = 0.dp,
    contentPadding: PaddingValues = PaddingValues(),
    itemKey: (T) -> String,
    additionalTopItems: LazyListScope.() -> Unit = {},
    content: @Composable (item: T) -> Unit,
) {
    LazyColumn(
        state = lazyListState,
        modifier = modifier,
        contentPadding = contentPadding,
        verticalArrangement = Arrangement.spacedBy(itemSpacing),
    ) {
        additionalTopItems()

        items(
            count = items.itemCount,
            key = { index ->
                val item = items[index]
                if (item != null) itemKey(item) else "empty"
            }
        ) { index ->
            items[index]?.let { item ->
                content(item)
            }
        }
        if (items.loadState.refresh is LoadState.Loading) {
            item(
                key = "Progress"
            ) {
                NextPageProgressView()
            }
        }
    }
}
