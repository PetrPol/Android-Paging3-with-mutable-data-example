package com.example.paging3withmutabledata.feature.shared.pagination.data

import kotlinx.coroutines.CoroutineScope

abstract class BaseCachedSearchPager<DataType : Any, IdKey : Any, Personalisation : Any>(
    coroutineScope: CoroutineScope,
    val pagingFactory: (String) -> DefaultPagingSource<DataType>,
) : BaseCachedPager<DataType, IdKey, Personalisation>(coroutineScope) {

    var query: String = ""

    override fun createPagingHandle(): SearchPagingHandle<DataType> {
        return SearchPagingHandleImpl(this)
    }

    override fun createPagingSource(): DefaultPagingSource<DataType> {
        return pagingFactory(query)
    }

    fun changeQuery(query: String) {
        if (this.query != query) {
            this.query = query
            refresh()
        }
    }
}
