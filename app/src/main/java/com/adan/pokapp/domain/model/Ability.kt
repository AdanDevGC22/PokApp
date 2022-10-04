package com.adan.pokapp.domain.model

import com.adan.pokapp.data.datasource.local.entity.AbilityEntity

data class Ability(val id: Long?, val name: String?, val url: String?)
fun Ability.toAbilityEntity() = AbilityEntity(this.id, this.name, this.url)
fun List<Ability>.toListAbilityEntity() = map { it.toAbilityEntity() }
