package com.example.paging3withmutabledata.feature.shared.pagination.data

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

class PagingHandleImpl<T : Any>(
    cachedPager: BaseCachedPager<T, *, *>,
) : PagingHandle<T> {

    override val getPagingDataStream: () -> Flow<PagingData<T>> = { cachedPager.pagingDataStream }

    override val refresh: () -> Unit = { cachedPager.refresh() }
}
