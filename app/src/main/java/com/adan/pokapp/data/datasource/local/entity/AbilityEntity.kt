package com.adan.pokapp.data.datasource.local.entity

import com.adan.pokapp.domain.model.Ability

data class AbilityEntity(val name: String?)
fun AbilityEntity.toAbility() = Ability(this.name)
