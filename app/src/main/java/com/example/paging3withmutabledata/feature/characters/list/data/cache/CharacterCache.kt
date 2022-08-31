package com.example.paging3withmutabledata.feature.characters.list.data.cache

import com.example.paging3withmutabledata.feature.characters.list.domain.CharacterId
import kotlinx.coroutines.flow.Flow

interface CharacterCache {

    fun getCharacterPersonalisationStream(): Flow<Map<CharacterId, CachedCharacterPersonalisation>>

    fun updateCharacterIsLiked(characterId: CharacterId, isLiked: Boolean)
}
