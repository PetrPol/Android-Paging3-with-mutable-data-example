package com.example.paging3withmutabledata.feature.shared.networking.di

import com.apollographql.apollo3.ApolloClient
import org.koin.dsl.module

val networkingModule = module {
    single {
        ApolloClient.Builder()
            .serverUrl("https://rickandmortyapi.com/graphql")
            .build()
    }
}
