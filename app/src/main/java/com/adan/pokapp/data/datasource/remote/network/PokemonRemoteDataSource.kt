package com.adan.pokapp.data.datasource.remote.network

import com.adan.pokapp.data.datasource.remote.model.PokemonModel

interface PokemonRemoteDataSource {

    suspend fun getPokemonsFromApi(): List<PokemonModel>
}