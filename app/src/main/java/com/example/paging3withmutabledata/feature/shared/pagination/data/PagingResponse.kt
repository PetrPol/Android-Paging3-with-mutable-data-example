package com.example.paging3withmutabledata.feature.shared.pagination.data

data class PagingResponse<T>(
    val nextPage: Int?,
    val data: List<T>
)

fun <T> emptyPagingResponse(): PagingResponse<T> {
    return PagingResponse(1, emptyList())
}
