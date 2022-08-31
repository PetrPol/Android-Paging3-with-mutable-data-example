package com.example.paging3withmutabledata.feature.characters.list.data

import com.example.paging3withmutabledata.feature.characters.list.domain.Character
import com.example.paging3withmutabledata.feature.characters.list.domain.CharacterId
import com.example.paging3withmutabledata.feature.shared.pagination.data.PagingRequest
import com.example.paging3withmutabledata.feature.shared.pagination.data.PagingResponse

interface CharacterRemoteDataSource {

    suspend fun getCharacters(pagingRequest: PagingRequest): PagingResponse<Character>

    suspend fun setCharacterIsLiked(characterId: CharacterId, isLiked: Boolean)

    suspend fun searchForCharacters(pagingRequest: PagingRequest, query: String): PagingResponse<Character>
}