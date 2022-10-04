package com.adan.pokapp.data.datasource.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.adan.pokapp.domain.model.Ability

@Entity(tableName = "ability_table")
data class AbilityEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Long?,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "url") val url: String?,
)
fun AbilityEntity.toAbility() = Ability(this.id, this.name, this.url)
fun List<AbilityEntity>.toListAbility() = map { it.toAbility() }
