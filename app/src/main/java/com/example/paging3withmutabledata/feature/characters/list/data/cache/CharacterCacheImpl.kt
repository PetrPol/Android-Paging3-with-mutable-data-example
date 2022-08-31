package com.example.paging3withmutabledata.feature.characters.list.data.cache

import com.example.paging3withmutabledata.feature.characters.list.domain.Character
import com.example.paging3withmutabledata.feature.characters.list.domain.CharacterId
import com.example.paging3withmutabledata.feature.characters.list.domain.CharacterPersonalisation
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class CharacterCacheImpl() : CharacterCache {

    private val cachedCharacterPersonalisationStream = MutableStateFlow<Map<CharacterId, CachedCharacterPersonalisation>>(emptyMap())

    override fun getCharacterPersonalisationStream(): Flow<Map<CharacterId, CachedCharacterPersonalisation>> {
        return cachedCharacterPersonalisationStream
    }

    override fun updateCharacterIsLiked(characterId: CharacterId, isLiked: Boolean) {
        updateCharacterCache(
            characterId = characterId,
            updatePersonalisation = { cachedViventPersonalisation -> cachedViventPersonalisation.copy(isLiked = isLiked) },
        )
    }

    private fun updateCharacterCache(
        characterId: CharacterId,
        updatePersonalisation: (CachedCharacterPersonalisation) -> CachedCharacterPersonalisation,
    ) {
        val characterPersonalisation = cachedCharacterPersonalisationStream.value[characterId] ?: CachedCharacterPersonalisation()
        val updatedCharacterPersonalisation = updatePersonalisation(characterPersonalisation)
        cachedCharacterPersonalisationStream.value += characterId to updatedCharacterPersonalisation
    }
}

fun Character.resolveCachedPersonalisation(cache: Map<CharacterId, CachedCharacterPersonalisation>): Character {
    val cachedPersonalisation = cache[id]
    return if (cachedPersonalisation != null) {
        copy(personalisation = cachedPersonalisation.mergeWithPersonalisation(personalisation))
    } else {
        this
    }
}

fun CachedCharacterPersonalisation.mergeWithPersonalisation(personalisation: CharacterPersonalisation): CharacterPersonalisation {
    return CharacterPersonalisation(
        isLiked = isLiked ?: personalisation.isLiked
    )
}
