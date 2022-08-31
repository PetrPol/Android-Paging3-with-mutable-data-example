package com.example.paging3withmutabledata.feature.characters.list.domain

data class Character(
    val id: CharacterId,
    val name: String,
    val status: String?,
    val species: String?,
    val type: String?,
    val image: String?,
    val personalisation: CharacterPersonalisation,
)

data class CharacterId(val value: String)