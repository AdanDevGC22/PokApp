package com.adan.pokapp.data.datasource.remote.model

import com.adan.pokapp.domain.model.MoveEffect
import com.google.gson.annotations.SerializedName

data class MoveEffectModel(@SerializedName("effect") val effect: String?)
fun MoveEffectModel.toMoveEffect() = MoveEffect(this.effect)
fun List<MoveEffectModel>.toListMoveEffect() = map { it.toMoveEffect() }
