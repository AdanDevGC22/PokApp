package com.adan.pokapp.data.datasource.remote.response

import com.adan.pokapp.data.datasource.remote.model.MoveEffectModel
import com.google.gson.annotations.SerializedName

data class MoveEffectResponse(@SerializedName("effect_entries") val moveEffects: List<MoveEffectModel>)
