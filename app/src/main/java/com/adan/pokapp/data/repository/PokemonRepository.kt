package com.adan.pokapp.data.repository

import com.adan.pokapp.domain.model.*

interface PokemonRepository {

    suspend fun getAllPokemonsFromRemote(): List<Pokemon>
    suspend fun getAbilitiesFromRemote(): List<Abilities>
    suspend fun getMovesFromRemote(): List<Moves>
    suspend fun getAbilityFromRemote(): List<AbilityEffect>
    suspend fun getMoveFromRemote(): List<MoveEffect>
    suspend fun getAllPokemonsFromLocal(): List<Pokemon>
    suspend fun insertAllPokemons(pokemons: List<Pokemon>)
}