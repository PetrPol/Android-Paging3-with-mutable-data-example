package com.example.paging3withmutabledata.feature.characters.list.presentation

import androidx.compose.runtime.Composable
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.example.paging3withmutabledata.feature.characters.list.domain.CharacterId
import com.example.paging3withmutabledata.feature.shared.core.presentation.BaseFragment

class CharacterListFragment : BaseFragment(), CharacterListActions {

    private val viewModel by viewModel<CharacterListViewModel>()

    @Composable
    override fun FragmentContent() {
        CharacterListScreen(viewModel, this)
    }

    override fun setCharacterIsLiked(characterId: CharacterId, isLiked: Boolean) {
        viewModel.setCharacterIsLiked(characterId, isLiked)
    }

    override fun refresh() {
        viewModel.refresh()
    }

    override fun queryChanged(query: String) {
        viewModel.queryChanged(query)
    }
}