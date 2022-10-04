package com.adan.pokapp.data.datasource.remote.response

import com.adan.pokapp.data.datasource.remote.model.AbilityModel
import com.google.gson.annotations.SerializedName

data class AbilityResponse(@SerializedName("results") val result: List<AbilityModel>)
