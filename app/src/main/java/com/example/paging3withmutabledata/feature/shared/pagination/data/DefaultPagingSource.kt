package com.example.paging3withmutabledata.feature.shared.pagination.data

import androidx.paging.PagingSource
import androidx.paging.PagingState

class DefaultPagingSource<T : Any>(
    val dataFetcher: suspend (PagingRequest) -> PagingResponse<T>,
) : PagingSource<Int, T>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, T> {
        return try {
            val pageIdentifier = params.key ?: 1
            val response = dataFetcher(PagingRequest(pageIdentifier))

            LoadResult.Page(
                data = response.data,
                prevKey = null,
                nextKey = response.nextPage,
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, T>): Int {
        return 1
    }
}
