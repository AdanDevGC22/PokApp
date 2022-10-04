package com.adan.pokapp.data.datasource.remote.network

import com.adan.pokapp.data.datasource.remote.model.*

interface PokemonRemoteDataSource {

    suspend fun getPokemonsFromApi(): List<PokemonModel>
    suspend fun getAbilitiesFromApi(): List<AbilityModel>
    suspend fun getMovesFromApi(): List<MoveModel>
   /* suspend fun getAbilitiesFromApi(): List<AbilitiesModel>
    suspend fun getMovesFromApi(): List<MovesModel>*/
   /* suspend fun getAbilityFromApi(): List<AbilityEffectModel>
    suspend fun getMoveFromApi(): List<MoveEffectModel>*/
  //  suspend fun getImageFromApi(): String
}