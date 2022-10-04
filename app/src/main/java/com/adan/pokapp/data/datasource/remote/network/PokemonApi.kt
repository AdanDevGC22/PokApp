package com.adan.pokapp.data.datasource.remote.network

import com.adan.pokapp.data.datasource.remote.response.*
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonApi {

    @GET("pokemon")
    suspend fun getPokemons(): Response<PokemonsResponse>

    @GET("pokemon/{id}")
    suspend fun getPokemon(@Path("id") id: Long): Response<PokemonResponse>

    @GET("ability")
    suspend fun getAbilities(): Response<AbilityResponse>

    @GET("move")
    suspend fun getMoves(): Response<MoveResponse>


    /*
     @GET("ability/{id}")
    suspend fun getAbility(@Path("id") id: Long): Response<AbilityEffectResponse>

    @GET("move/{id}")
    suspend fun getMove(@Path("id") id: Long): Response<MoveEffectResponse>

    @GET("pokemon-form/{id}")
    suspend fun getPokemonImage(@Path("id") id: Long): Response<FormResponse>
    */

}