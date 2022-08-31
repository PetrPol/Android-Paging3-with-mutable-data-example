package com.example.paging3withmutabledata.feature.shared.pagination.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.example.paging3withmutabledata.feature.characters.list.domain.Character
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine

abstract class BaseCachedPager<DataType : Any, IdKey : Any, Personalisation : Any>(
    coroutineScope: CoroutineScope,
) {

    private var pagingSource: DefaultPagingSource<DataType>? = null
    val pagingDataStream: Flow<PagingData<DataType>> by lazy {
        Pager(PagingConfig(pageSize)) { createPagingSource().apply { pagingSource = this } }
            .flow
            .cachedIn(coroutineScope)
            .combine(getCachedInfoStream()) { pagingData, cachedPersonalisation ->
                pagingData.map { item ->
                    mergeWithCache(item, cachedPersonalisation)
                }
            }
    }

    abstract fun getCachedInfoStream(): Flow<Map<IdKey, Personalisation>>

    abstract fun mergeWithCache(item: DataType, cachedInfo: Map<IdKey, Personalisation>): DataType

    abstract fun createPagingSource(): DefaultPagingSource <DataType>

    open fun createPagingHandle(): PagingHandle<DataType> {
        return PagingHandleImpl(this)
    }

    fun refresh() {
        pagingSource?.invalidate()
    }

    companion object {

        const val pageSize = 20
    }
}
