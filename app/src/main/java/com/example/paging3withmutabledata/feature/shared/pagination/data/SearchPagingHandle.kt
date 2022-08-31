package com.example.paging3withmutabledata.feature.shared.pagination.data

interface SearchPagingHandle<T : Any> : PagingHandle<T> {

    val updateQuery: (query: String) -> Unit

    val query: String
}
