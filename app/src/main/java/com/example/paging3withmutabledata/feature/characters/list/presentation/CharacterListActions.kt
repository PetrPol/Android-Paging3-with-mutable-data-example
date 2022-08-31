package com.example.paging3withmutabledata.feature.characters.list.presentation

import androidx.compose.runtime.Stable
import com.example.paging3withmutabledata.feature.characters.list.domain.CharacterId

@Stable
interface CharacterListActions {

    fun setCharacterIsLiked(characterId: CharacterId, isLiked: Boolean)

    fun refresh()

    fun queryChanged(query: String)
}
