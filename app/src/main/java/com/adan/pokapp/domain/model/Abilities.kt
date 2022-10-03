package com.adan.pokapp.domain.model

import com.adan.pokapp.data.datasource.local.entity.AbilitiesEntity

data class Abilities(
   val idPokemon: Long?,
   val ability: Ability?,
   val isHidden: Boolean?
)

fun Abilities.toAbilitiesEntity() = AbilitiesEntity(
   this.idPokemon,
   this.ability?.toAbilityEntity(),
   this.isHidden
)

fun List<Abilities>.toListAbilitiesEntity() = map { it.toAbilitiesEntity() }