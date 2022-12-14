package com.example.paging3withmutabledata.feature.characters.list.data.cache

import com.example.paging3withmutabledata.feature.characters.list.domain.Character
import com.example.paging3withmutabledata.feature.characters.list.domain.CharacterId
import com.example.paging3withmutabledata.feature.shared.pagination.data.BaseCachedPager
import com.example.paging3withmutabledata.feature.shared.pagination.data.DefaultPagingSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

class CachedCharacterPager(
    private val characterCache: CharacterCache,
    coroutineScope: CoroutineScope,
    private val pagingFactory: () -> DefaultPagingSource<Character>,
) : BaseCachedPager<Character, CharacterId, CachedCharacterPersonalisation>(coroutineScope) {

    override fun getCachedInfoStream(): Flow<Map<CharacterId, CachedCharacterPersonalisation>> {
        return characterCache.getCharacterPersonalisationStream()
    }

    override fun mergeWithCache(item: Character, cachedInfo: Map<CharacterId, CachedCharacterPersonalisation>): Character {
        return item.resolveCachedPersonalisation(cachedInfo)
    }

    override fun createPagingSource(): DefaultPagingSource<Character> {
        return pagingFactory()
    }
}
