package com.example.paging3withmutabledata.feature.characters.list.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.paging3withmutabledata.R
import com.example.paging3withmutabledata.feature.shared.core.presentation.ApplicationTheme
import com.example.paging3withmutabledata.feature.shared.core.presentation.BaseHandleOfErrors
import com.example.paging3withmutabledata.feature.shared.core.presentation.PaginatedLazyColumn
import com.example.paging3withmutabledata.feature.shared.core.presentation.collectScreenState
import com.example.paging3withmutabledata.feature.shared.core.presentation.views.Characters
import com.example.paging3withmutabledata.feature.shared.pagination.presentation.EmptyState
import com.example.paging3withmutabledata.feature.shared.pagination.presentation.OnError
import com.example.paging3withmutabledata.feature.shared.pagination.presentation.collectAsLazyPagingItems
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshState
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@Composable
fun CharacterListScreen(viewModel: CharacterListViewModel, actions: CharacterListActions) {
    val screenState by viewModel.collectScreenState()

    val scaffoldState = rememberScaffoldState()
    val swipeRefreshState = rememberSwipeRefreshState(isRefreshing = false)

    Scaffold(
        scaffoldState = scaffoldState,
    ) { paddingValues ->

        SwipeRefresh(
            modifier = Modifier.fillMaxSize(),
            state = swipeRefreshState,
            onRefresh = {
                actions.refresh()
                swipeRefreshState.isRefreshing = true
            }
        ) {
            ScreenContent(actions = actions, screenState, scaffoldState, swipeRefreshState, paddingValues)
        }
    }
}

@Composable
fun ScreenContent(
    actions: CharacterListActions,
    screenState: ScreenState,
    scaffoldState: ScaffoldState,
    swipeRefreshState: SwipeRefreshState,
    paddingValues: PaddingValues,
) {
    screenState.charactersPagingHandle?.collectAsLazyPagingItems()?.apply {
        LaunchedEffect(itemSnapshotList) {
            if (swipeRefreshState.isRefreshing && itemCount > 0) {
                swipeRefreshState.isRefreshing = false
            }
        }
        PaginatedLazyColumn(
            modifier = Modifier.padding(paddingValues),
            items = this,
            itemSpacing = 8.dp,
            itemKey = { it.id.value },
            contentPadding = PaddingValues(vertical = 8.dp, horizontal = 8.dp),
        ) { character ->
            Characters.ListItem(
                character = character,
                onLikeClicked = actions::setCharacterIsLiked
            )
        }

        EmptyState {
            Text(
                modifier = Modifier.fillMaxSize(),
                text = stringResource(R.string.character_list_empty_screen),
                textAlign = TextAlign.Center,
            )
        }

        OnError { error ->
            BaseHandleOfErrors(error, scaffoldState.snackbarHostState)
            swipeRefreshState.isRefreshing = false

            if (itemCount==0) {
                Box(
                    modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = stringResource(R.string.character_list_error),
                            style = ApplicationTheme.typography.paragraphs.large,
                            textAlign = TextAlign.Center,
                        )

                        Button(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 16.dp),
                            onClick = actions::refresh
                        ) {
                            Text(
                                text = stringResource(R.string.character_list_reload_button),
                                textAlign = TextAlign.Center,
                            )
                        }
                    }
                }
            }
        }
    }
}
