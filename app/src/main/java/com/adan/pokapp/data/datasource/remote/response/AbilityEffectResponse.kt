package com.adan.pokapp.data.datasource.remote.response

import com.adan.pokapp.data.datasource.remote.model.AbilityEffectModel
import com.google.gson.annotations.SerializedName

data class AbilityEffectResponse(@SerializedName("effect_entries") val abilityEffects: List<AbilityEffectModel>)
