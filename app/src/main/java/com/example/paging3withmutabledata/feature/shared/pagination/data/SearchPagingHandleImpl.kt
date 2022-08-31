package com.example.paging3withmutabledata.feature.shared.pagination.data

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

class SearchPagingHandleImpl<T : Any>(
    cachedSearchPager: BaseCachedSearchPager<T, *, *>,
) : SearchPagingHandle<T> {

    override val getPagingDataStream: () -> Flow<PagingData<T>> = { cachedSearchPager.pagingDataStream }

    override val updateQuery: (query: String) -> Unit = { cachedSearchPager.changeQuery(it) }

    override val refresh: () -> Unit = { cachedSearchPager.refresh() }

    override val query: String = cachedSearchPager.query
}
