package com.adan.pokapp.data.datasource.remote.network

import com.adan.pokapp.data.datasource.remote.response.PokemonResponse
import retrofit2.Response
import retrofit2.http.GET

interface PokemonApi {

    @GET("pokemon")
    suspend fun getPokemons(): Response<PokemonResponse>
}