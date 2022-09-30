package com.adan.pokapp.data.repository

import com.adan.pokapp.data.datasource.remote.model.*
import com.adan.pokapp.domain.model.*

interface PokemonRepository {

    suspend fun getAllPokemonsFromRemote(): List<Pokemon>
    suspend fun getAbilitiesFromRemote(id: Long): List<Abilities>
    suspend fun getAbilityFromRemote(id: Long): List<AbilityEffect>
    suspend fun getMoveFromRemote(id: Long): List<MoveEffect>
    suspend fun getImageFromRemote(id: Long): Sprites
}