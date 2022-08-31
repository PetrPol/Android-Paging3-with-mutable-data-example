package com.example.paging3withmutabledata.feature.shared.pagination.presentation

import androidx.compose.runtime.Composable
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems

@Composable
fun <T : Any> LazyPagingItems<T>.OnError(
    content: @Composable (Throwable) -> Unit,
) {
    val loadStateAppend = loadState.append
    val loadStateRefresh = loadState.refresh
    when {
        loadStateRefresh is LoadState.Error -> content(loadStateRefresh.error)
        loadStateAppend is LoadState.Error -> content(loadStateAppend.error)
    }
}

@Composable
fun <T : Any> LazyPagingItems<T>.EmptyState(
    content: @Composable () -> Unit,
) {
    if (itemCount == 0 && loadState.append.endOfPaginationReached) {
        content()
    }
}
