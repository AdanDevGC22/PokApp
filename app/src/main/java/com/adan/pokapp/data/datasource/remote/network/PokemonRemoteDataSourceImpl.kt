package com.adan.pokapp.data.datasource.remote.network

import com.adan.pokapp.data.datasource.remote.model.PokemonModel
import javax.inject.Inject

class PokemonRemoteDataSourceImpl @Inject constructor(private val pokemonApi: PokemonApi) : PokemonRemoteDataSource {

    override suspend fun getPokemonsFromApi(): List<PokemonModel> {
        return pokemonApi.getPokemons().let { it.body()!!.result }
    }
}