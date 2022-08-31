package com.example.paging3withmutabledata.feature.characters.list.domain

import com.example.paging3withmutabledata.feature.shared.pagination.data.PagingHandle
import com.example.paging3withmutabledata.feature.shared.pagination.data.SearchPagingHandle
import kotlinx.coroutines.CoroutineScope

interface CharacterRepository {

    fun getCharacterStream(coroutineScope: CoroutineScope): PagingHandle<Character>

    fun getCharacterSearchStream(coroutineScope: CoroutineScope): SearchPagingHandle<Character>

    suspend fun setCharacterIsLiked(characterId: CharacterId, isLiked: Boolean)
}