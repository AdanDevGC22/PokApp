package com.adan.pokapp.data.repository

import com.adan.pokapp.data.datasource.remote.model.PokemonModel
import com.adan.pokapp.data.datasource.remote.network.PokemonRemoteDataSource
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(private val remoteDataSource: PokemonRemoteDataSource) : PokemonRepository {

    override suspend fun getAllPokemonsFromRemote(): List<PokemonModel> {
        return remoteDataSource.getPokemonsFromApi()
    }
}