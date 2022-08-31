package com.example.paging3withmutabledata.feature.characters.list.domain

import com.example.paging3withmutabledata.feature.shared.pagination.data.PagingHandle
import kotlinx.coroutines.CoroutineScope

interface CharacterRepository {

    fun getCharacterStream(coroutineScope: CoroutineScope): PagingHandle<Character>

    suspend fun setCharacterIsLiked(characterId: CharacterId, isLiked: Boolean)
}