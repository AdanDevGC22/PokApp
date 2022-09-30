package com.adan.pokapp.data.datasource.remote.model

import com.adan.pokapp.domain.model.Pokemon
import com.google.gson.annotations.SerializedName

data class PokemonModel(@SerializedName("name") val name: String?)
fun PokemonModel.toPokemon() = Pokemon(this.name)
fun List<PokemonModel>.toListPokemon() = map { it.toPokemon() }