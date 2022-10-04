package com.adan.pokapp.data.datasource.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.adan.pokapp.domain.model.AbilityEffect

@Entity(tableName = "description_table")
data class AbilityEffectEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Long?,
    @ColumnInfo(name = "description") val effect: String?
)

fun AbilityEffectEntity.toAbilityEffect() = AbilityEffect(this.id, this.effect)
fun List<AbilityEffectEntity>.toListAbilityEffect() = map { it.toAbilityEffect() }
