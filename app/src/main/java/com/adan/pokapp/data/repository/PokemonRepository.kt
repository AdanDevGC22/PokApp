package com.adan.pokapp.data.repository

import com.adan.pokapp.data.datasource.local.entity.AbilityEffectEntity
import com.adan.pokapp.data.datasource.local.entity.AbilityEntity
import com.adan.pokapp.data.datasource.local.entity.MoveEntity
import com.adan.pokapp.domain.model.*

interface PokemonRepository {

    suspend fun getAllPokemonsFromRemote(): List<Pokemon>
    suspend fun getAllAbilitiesFromRemote(): List<Ability>
    suspend fun getAllMovesFromRemote(): List<Move>
  /*  suspend fun getAbilitiesFromRemote(): List<Abilities>
    suspend fun getMovesFromRemote(): List<Moves>*/
  //  suspend fun getAbilityFromRemote(): List<AbilityEffect>
 //   suspend fun getMoveFromRemote(): List<MoveEffect>
    suspend fun getAllPokemonsFromLocal(): List<Pokemon>
    suspend fun insertAllPokemons(pokemons: List<Pokemon>)
    suspend fun getAllAbilitiesFromLocal(): List<Ability>
    suspend fun insertAllAbilities(abilities: List<Ability>)
    suspend fun getAllMovesFromLocal(): List<Move>
    suspend fun insertAllMoves(moves: List<Move>)
}