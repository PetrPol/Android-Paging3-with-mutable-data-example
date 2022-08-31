package com.example.paging3withmutabledata.feature.characters.list.data.cache

import com.example.paging3withmutabledata.feature.characters.list.domain.Character
import com.example.paging3withmutabledata.feature.characters.list.domain.CharacterId
import com.example.paging3withmutabledata.feature.shared.pagination.data.BaseCachedSearchPager
import com.example.paging3withmutabledata.feature.shared.pagination.data.DefaultPagingSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

class CachedCharacterSearchPager(
    private val characterCache: CharacterCache,
    coroutineScope: CoroutineScope,
    pagingFactory: (String) -> DefaultPagingSource<Character>,
) : BaseCachedSearchPager<Character, CharacterId, CachedCharacterPersonalisation>(coroutineScope, pagingFactory) {

    override fun getCachedInfoStream(): Flow<Map<CharacterId, CachedCharacterPersonalisation>> {
        return characterCache.getCharacterPersonalisationStream()
    }

    override fun mergeWithCache(item: Character, cachedInfo: Map<CharacterId, CachedCharacterPersonalisation>): Character {
        return item.resolveCachedPersonalisation(cachedInfo)
    }
}
