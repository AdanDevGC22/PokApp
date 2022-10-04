package com.adan.pokapp.domain.model

import com.adan.pokapp.data.datasource.local.entity.AbilityEffectEntity

data class AbilityEffect(val id: Long?, val effect: String?)
fun AbilityEffect.toAbilityEffectEntity() = AbilityEffectEntity(this.id, this.effect)
fun List<AbilityEffect>.toListAbilityEffectEntity() = map { it.toAbilityEffectEntity() }
