package com.adan.pokapp.domain.model

import com.adan.pokapp.data.datasource.local.entity.AbilityEntity

data class Ability(val name: String?)
fun Ability.toAbilityEntity() = AbilityEntity(this.name)
