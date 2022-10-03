package com.adan.pokapp.data.datasource.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.adan.pokapp.data.datasource.local.entity.AbilitiesEntity
import com.adan.pokapp.data.datasource.local.entity.PokemonEntity
import com.adan.pokapp.data.datasource.local.response.PokemonResponseEntity
import com.adan.pokapp.domain.model.Pokemon

@Dao
interface PokemonDao {

    @Query("SELECT * FROM pokemon_table ORDER BY id ASC")
    suspend fun getAllPokemons(): List<PokemonEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllPokemons(abilities: List<PokemonEntity>)
}