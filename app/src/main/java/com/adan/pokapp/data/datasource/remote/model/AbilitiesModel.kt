package com.adan.pokapp.data.datasource.remote.model

import com.google.gson.annotations.SerializedName

data class AbilitiesModel(
    @SerializedName("ability") val ability: AbilityModel?,
    @SerializedName("is_hidden") val isHidden: Boolean?
)