package com.example.paging3withmutabledata.feature.characters.list.di

import com.example.paging3withmutabledata.feature.characters.list.data.CharacterRemoteDataSource
import com.example.paging3withmutabledata.feature.characters.list.data.CharacterRepositoryImpl
import com.example.paging3withmutabledata.feature.characters.list.data.api.CharacterGraphQlDataSource
import com.example.paging3withmutabledata.feature.characters.list.data.cache.CharacterCache
import com.example.paging3withmutabledata.feature.characters.list.data.cache.CharacterCacheImpl
import com.example.paging3withmutabledata.feature.characters.list.domain.CharacterRepository
import com.example.paging3withmutabledata.feature.characters.list.presentation.CharacterListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val characterModule = module {

    singleOf(::CharacterRepositoryImpl) { bind<CharacterRepository>() }

    singleOf(::CharacterCacheImpl) { bind<CharacterCache>() }

    factory<CharacterRemoteDataSource> {
        CharacterGraphQlDataSource(apolloClient = get())
    }

    viewModel { CharacterListViewModel(characterRepository = get()) }
}
