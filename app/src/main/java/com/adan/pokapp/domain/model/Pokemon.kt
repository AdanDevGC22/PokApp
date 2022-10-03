package com.adan.pokapp.domain.model

import com.adan.pokapp.data.datasource.local.entity.PokemonEntity
import com.adan.pokapp.data.datasource.remote.model.PokemonModel

data class Pokemon(val id: Long?, val name: String?, val url: String?)
fun Pokemon.toPokemonEntity() = PokemonEntity(this.id, this.name, this.url)
fun List<Pokemon>.toListPokemonEntity() = map { it.toPokemonEntity() }
fun Pokemon.toPokemonModel() = PokemonModel(this.id, this.name, this.url)

