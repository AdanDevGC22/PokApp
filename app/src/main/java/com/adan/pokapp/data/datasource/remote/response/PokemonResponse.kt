package com.adan.pokapp.data.datasource.remote.response

import com.adan.pokapp.data.datasource.remote.model.AbilitiesModel
import com.adan.pokapp.data.datasource.remote.model.MovesModel
import com.adan.pokapp.data.datasource.remote.model.OtherModel
import com.google.gson.annotations.SerializedName

data class PokemonResponse(
    @SerializedName("id") val idPokemon: Long?,
    @SerializedName("abilities") val abilitiesModel: List<AbilitiesModel>,
    @SerializedName("moves") val movesModel: List<MovesModel>,
    @SerializedName("sprites") val otherModel: OtherModel
)
