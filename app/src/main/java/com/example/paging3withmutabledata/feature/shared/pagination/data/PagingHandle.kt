package com.example.paging3withmutabledata.feature.shared.pagination.data

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

interface PagingHandle<T : Any> {

    val getPagingDataStream: () -> Flow<PagingData<T>>

    val refresh: () -> Unit
}
