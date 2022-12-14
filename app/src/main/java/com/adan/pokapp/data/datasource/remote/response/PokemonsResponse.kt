package com.adan.pokapp.data.datasource.remote.response

import com.adan.pokapp.data.datasource.remote.model.PokemonModel
import com.google.gson.annotations.SerializedName

data class PokemonsResponse(
    @SerializedName("results") val result: List<PokemonModel>
)
