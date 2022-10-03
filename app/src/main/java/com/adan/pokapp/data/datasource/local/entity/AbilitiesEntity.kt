package com.adan.pokapp.data.datasource.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.adan.pokapp.domain.model.Abilities

data class AbilitiesEntity(
    val id: Long?,
    val abilityEntity: AbilityEntity?,
    val isHidden: Boolean?
)

fun AbilitiesEntity.toAbilities() = Abilities(
    this.id,
    this.abilityEntity?.toAbility(),
    this.isHidden
)

fun List<AbilitiesEntity>.toListAbilities() = map { it.toAbilities() }