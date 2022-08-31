package com.example.paging3withmutabledata.feature.characters.list.presentation

import androidx.lifecycle.viewModelScope
import com.example.paging3withmutabledata.feature.characters.list.domain.Character
import com.example.paging3withmutabledata.feature.characters.list.domain.CharacterId
import com.example.paging3withmutabledata.feature.characters.list.domain.CharacterRepository
import com.example.paging3withmutabledata.feature.shared.core.presentation.ScreenStateViewModel
import com.example.paging3withmutabledata.feature.shared.pagination.data.PagingHandle
import com.example.paging3withmutabledata.feature.shared.pagination.data.SearchPagingHandle
import kotlinx.coroutines.launch

/**
 * ViewModel for a [CharacterListFragment] screen
 */
class CharacterListViewModel(
    private val characterRepository: CharacterRepository
) : ScreenStateViewModel<ScreenState>(ScreenState()) {

    init {
        val charactersPagingHandle = characterRepository.getCharacterSearchStream(viewModelScope)
        setState { copy(charactersPagingHandle = charactersPagingHandle) }
    }

    fun refresh(){
        screenState.charactersPagingHandle?.refresh?.invoke()
    }

    fun queryChanged(query: String){
        screenState.charactersPagingHandle?.updateQuery?.invoke(query)
        setState { copy(query = query) }
    }

    fun setCharacterIsLiked(characterId: CharacterId, isLiked: Boolean){
        viewModelScope.launch {
            try {
                characterRepository.setCharacterIsLiked(characterId, isLiked)
            } catch (e: Throwable){
                setState { copy(error = e) }
            }

        }
    }
}

data class ScreenState(
    val charactersPagingHandle: SearchPagingHandle<Character>? = null,
    val error: Throwable? = null,
    val query: String = ""
)
