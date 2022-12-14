//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.5.0'.
//
package com.example.paging3withmutabledata.networking.graphql.selections

import com.apollographql.apollo3.api.CompiledArgument
import com.apollographql.apollo3.api.CompiledField
import com.apollographql.apollo3.api.CompiledFragment
import com.apollographql.apollo3.api.CompiledSelection
import com.apollographql.apollo3.api.CompiledVariable
import com.apollographql.apollo3.api.list
import com.apollographql.apollo3.api.notNull
import com.example.paging3withmutabledata.networking.graphql.fragment.selections.CharacterViewSelections
import com.example.paging3withmutabledata.networking.graphql.type.Character
import com.example.paging3withmutabledata.networking.graphql.type.Characters
import com.example.paging3withmutabledata.networking.graphql.type.GraphQLInt
import com.example.paging3withmutabledata.networking.graphql.type.GraphQLString
import com.example.paging3withmutabledata.networking.graphql.type.Info
import kotlin.collections.List

public object GetCharactersQuerySelections {
  private val __info: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "next",
          type = GraphQLInt.type
        ).build()
      )

  private val __results: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "__typename",
          type = GraphQLString.type.notNull()
        ).build(),
        CompiledFragment.Builder(
          typeCondition = "Character",
          possibleTypes = (listOf("Character"))
        ).selections(CharacterViewSelections.__root)
        .build()
      )

  private val __characters: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "info",
          type = Info.type
        ).selections(__info)
        .build(),
        CompiledField.Builder(
          name = "results",
          type = Character.type.list()
        ).selections(__results)
        .build()
      )

  public val __root: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "characters",
          type = Characters.type
        ).arguments(listOf(
          CompiledArgument.Builder("page", CompiledVariable("page")).build()
        ))
        .selections(__characters)
        .build()
      )
}
