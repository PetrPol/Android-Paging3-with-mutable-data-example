//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.5.0'.
//
package com.example.paging3withmutabledata.networking.graphql.fragment

import com.apollographql.apollo3.api.Adapter
import com.apollographql.apollo3.api.CustomScalarAdapters
import com.apollographql.apollo3.api.NullableStringAdapter
import com.apollographql.apollo3.api.json.JsonReader
import com.apollographql.apollo3.api.json.JsonWriter
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

public object CharacterViewImpl_ResponseAdapter {
  public object CharacterView :
      Adapter<com.example.paging3withmutabledata.networking.graphql.fragment.CharacterView> {
    public val RESPONSE_NAMES: List<String> = listOf("id", "name", "status", "species", "type",
        "image")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        com.example.paging3withmutabledata.networking.graphql.fragment.CharacterView {
      var _id: String? = null
      var _name: String? = null
      var _status: String? = null
      var _species: String? = null
      var _type: String? = null
      var _image: String? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _id = NullableStringAdapter.fromJson(reader, customScalarAdapters)
          1 -> _name = NullableStringAdapter.fromJson(reader, customScalarAdapters)
          2 -> _status = NullableStringAdapter.fromJson(reader, customScalarAdapters)
          3 -> _species = NullableStringAdapter.fromJson(reader, customScalarAdapters)
          4 -> _type = NullableStringAdapter.fromJson(reader, customScalarAdapters)
          5 -> _image = NullableStringAdapter.fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return com.example.paging3withmutabledata.networking.graphql.fragment.CharacterView(
        id = _id,
        name = _name,
        status = _status,
        species = _species,
        type = _type,
        image = _image
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: com.example.paging3withmutabledata.networking.graphql.fragment.CharacterView,
    ): Unit {
      writer.name("id")
      NullableStringAdapter.toJson(writer, customScalarAdapters, value.id)

      writer.name("name")
      NullableStringAdapter.toJson(writer, customScalarAdapters, value.name)

      writer.name("status")
      NullableStringAdapter.toJson(writer, customScalarAdapters, value.status)

      writer.name("species")
      NullableStringAdapter.toJson(writer, customScalarAdapters, value.species)

      writer.name("type")
      NullableStringAdapter.toJson(writer, customScalarAdapters, value.type)

      writer.name("image")
      NullableStringAdapter.toJson(writer, customScalarAdapters, value.image)
    }
  }
}