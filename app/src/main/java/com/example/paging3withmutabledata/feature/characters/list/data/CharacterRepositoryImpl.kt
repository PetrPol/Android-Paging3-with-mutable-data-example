package com.example.paging3withmutabledata.feature.characters.list.data

import com.example.paging3withmutabledata.feature.characters.list.data.cache.CachedCharacterPager
import com.example.paging3withmutabledata.feature.characters.list.data.cache.CharacterCache
import com.example.paging3withmutabledata.feature.characters.list.domain.Character
import com.example.paging3withmutabledata.feature.characters.list.domain.CharacterId
import com.example.paging3withmutabledata.feature.characters.list.domain.CharacterRepository
import com.example.paging3withmutabledata.feature.shared.pagination.data.DefaultPagingSource
import com.example.paging3withmutabledata.feature.shared.pagination.data.PagingHandle
import kotlinx.coroutines.CoroutineScope

class CharacterRepositoryImpl(
    private val remoteDataSource: CharacterRemoteDataSource,
    private val characterCache: CharacterCache,
) : CharacterRepository {

    override fun getCharacterStream(coroutineScope: CoroutineScope): PagingHandle<Character> {
        return CachedCharacterPager(characterCache, coroutineScope) {
            DefaultPagingSource { pagingRequest ->
                remoteDataSource.getCharacters(pagingRequest)
            }
        }.createPagingHandle()
    }

    override suspend fun setCharacterIsLiked(characterId: CharacterId, isLiked: Boolean) {
        characterCache.updateCharacterIsLiked(characterId, isLiked)
        try {
            remoteDataSource.setCharacterIsLiked(characterId, isLiked)
        } catch (e: Exception) {
            characterCache.updateCharacterIsLiked(characterId, !isLiked)
            throw e
        }
    }
}