package com.adan.pokapp.data.datasource.remote.model

import com.adan.pokapp.domain.model.AbilityEffect
import com.google.gson.annotations.SerializedName

data class AbilityEffectModel(@SerializedName("effect") val effect: String?)
fun AbilityEffectModel.toAbilityEffect() = AbilityEffect(this.effect)
fun List<AbilityEffectModel>.toListAbilityEffect() = map { it.toAbilityEffect() }