package com.adan.pokapp.data.datasource.remote.model

import com.adan.pokapp.domain.model.Pokemon
import com.google.gson.annotations.SerializedName

data class PokemonModel(
    var id:Long?,
    @SerializedName("name") val name: String?,
    @SerializedName("url") val url: String?) {

    fun getImageUrl(): String {
        val index = url?.split("/".toRegex())?.dropLast(1)?.last()
        return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$index.png"
    }

    fun getIdPokemon(): Long? {
        val urlPart: Array<String>? = url?.split("/")?.toTypedArray()
        return urlPart?.get(urlPart.size - 2)?.toLong()
    }
}
fun PokemonModel.toPokemon() = Pokemon(this.id, this.name, this.url)
fun List<PokemonModel>.toListPokemon() = map { it.toPokemon() }