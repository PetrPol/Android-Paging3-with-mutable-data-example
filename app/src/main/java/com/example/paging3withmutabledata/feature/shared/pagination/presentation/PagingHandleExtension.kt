package com.example.paging3withmutabledata.feature.shared.pagination.presentation

import androidx.compose.runtime.Composable
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.paging3withmutabledata.feature.shared.pagination.data.PagingHandle

@Composable
fun <T : Any> PagingHandle<T>.collectAsLazyPagingItems(): LazyPagingItems<T> {
    return getPagingDataStream().collectAsLazyPagingItems()
}
