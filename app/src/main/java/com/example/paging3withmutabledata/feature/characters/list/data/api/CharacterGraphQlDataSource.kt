package com.example.paging3withmutabledata.feature.characters.list.data.api

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.api.Optional
import com.example.paging3withmutabledata.feature.characters.list.data.CharacterRemoteDataSource
import com.example.paging3withmutabledata.feature.characters.list.domain.Character
import com.example.paging3withmutabledata.feature.characters.list.domain.CharacterId
import com.example.paging3withmutabledata.feature.characters.list.domain.CharacterPersonalisation
import com.example.paging3withmutabledata.feature.shared.networking.data.NetworkException
import com.example.paging3withmutabledata.feature.shared.pagination.data.PagingRequest
import com.example.paging3withmutabledata.feature.shared.pagination.data.PagingResponse
import com.example.paging3withmutabledata.networking.graphql.GetCharactersQuery
import com.example.paging3withmutabledata.networking.graphql.fragment.CharacterView

class CharacterGraphQlDataSource(
    private val apolloClient: ApolloClient,
) : CharacterRemoteDataSource {

    override suspend fun getCharacters(pagingRequest: PagingRequest): PagingResponse<Character> {
        val response = apolloClient.query(
            GetCharactersQuery(Optional.presentIfNotNull(pagingRequest.nextPage))
        ).execute()
        if (response.hasErrors()) throw NetworkException()
        return PagingResponse(
            response.data?.characters?.info?.next,
            response.data?.characters?.results?.mapNotNull { it?.characterView?.toDomain() } ?: emptyList()
        )
    }

    override suspend fun setCharacterIsLiked(characterId: CharacterId, isLiked: Boolean) {
        // Call Api endpoint to store actual state of like
    }
}

fun CharacterView.toDomain(): Character? {
    return if (id != null) {
         Character(
            id = CharacterId(id),
            name = name ?: "unknown",
            species = if (species?.isNotBlank() == true) species else null,
            status = if (status?.isNotBlank() == true) status else null,
            type = if (type?.isNotBlank() == true) type else null,
            image = image,
            personalisation = CharacterPersonalisation(isLiked = false) // Should be get from API
        )
    } else {
        null
    }
}