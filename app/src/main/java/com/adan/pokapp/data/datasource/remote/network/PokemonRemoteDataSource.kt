package com.adan.pokapp.data.datasource.remote.network

import com.adan.pokapp.data.datasource.remote.model.*

interface PokemonRemoteDataSource {

    suspend fun getPokemonsFromApi(): List<PokemonModel>
    suspend fun getAbilitiesFromApi(id: Long): List<AbilitiesModel>
    suspend fun getAbilityFromApi(id: Long): List<AbilityEffectModel>
    suspend fun getMoveFromApi(id: Long): List<MoveEffectModel>
    suspend fun getImageFromApi(id: Long): SpritesModel
}