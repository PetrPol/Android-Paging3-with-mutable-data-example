//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.5.0'.
//
package com.example.paging3withmutabledata.networking.graphql.adapter

import com.apollographql.apollo3.api.Adapter
import com.apollographql.apollo3.api.CustomScalarAdapters
import com.apollographql.apollo3.api.NullableIntAdapter
import com.apollographql.apollo3.api.Optional
import com.apollographql.apollo3.api.json.JsonReader
import com.apollographql.apollo3.api.json.JsonWriter
import com.apollographql.apollo3.api.optional
import com.example.paging3withmutabledata.networking.graphql.GetCharactersQuery
import kotlin.IllegalStateException
import kotlin.Unit

public object GetCharactersQuery_VariablesAdapter : Adapter<GetCharactersQuery> {
  public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
      GetCharactersQuery = throw IllegalStateException("Input type used in output position")

  public override fun toJson(
    writer: JsonWriter,
    customScalarAdapters: CustomScalarAdapters,
    `value`: GetCharactersQuery,
  ): Unit {
    if (value.page is Optional.Present) {
      writer.name("page")
      NullableIntAdapter.optional().toJson(writer, customScalarAdapters, value.page)
    }
  }
}
