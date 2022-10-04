package com.adan.pokapp.data.datasource.local

import com.adan.pokapp.data.datasource.local.entity.AbilityEntity
import com.adan.pokapp.data.datasource.local.entity.MoveEntity
import com.adan.pokapp.data.datasource.local.entity.PokemonEntity

interface PokemonLocalDataSource {

    suspend fun getAllPokemons(): List<PokemonEntity>
    suspend fun insertAllPokemons(pokemons: List<PokemonEntity>)
    suspend fun getAllAbilities(): List<AbilityEntity>
    suspend fun insertAllAbilities(abilities: List<AbilityEntity>)
    suspend fun getAllMoves(): List<MoveEntity>
    suspend fun insertAllMoves(moves: List<MoveEntity>)
}