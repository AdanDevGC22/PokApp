package com.adan.pokapp.data.datasource.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.adan.pokapp.domain.model.Pokemon

@Entity(tableName = "pokemon_table")
data class PokemonEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Long?,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "url") val url: String?)
fun PokemonEntity.toPokemon() = Pokemon(this.id, this.name, this.url)
fun List<PokemonEntity>.toListPokemon() = map { it.toPokemon() }

