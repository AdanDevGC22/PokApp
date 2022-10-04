package com.adan.pokapp.data.datasource.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.adan.pokapp.data.datasource.local.entity.AbilityEntity
import com.adan.pokapp.data.datasource.local.entity.MoveEntity
import com.adan.pokapp.data.datasource.local.entity.PokemonEntity

@Dao
interface PokemonDao {

    @Query("SELECT * FROM pokemon_table ORDER BY id ASC")
    suspend fun getAllPokemons(): List<PokemonEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllPokemons(pokemons: List<PokemonEntity>)

    @Query("SELECT * FROM ability_table ORDER BY id ASC")
    suspend fun getAllAbilities(): List<AbilityEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllAbilities(abilities: List<AbilityEntity>)

    @Query("SELECT * FROM move_table ORDER BY id ASC")
    suspend fun getAllMoves(): List<MoveEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllMoves(moves: List<MoveEntity>)
}