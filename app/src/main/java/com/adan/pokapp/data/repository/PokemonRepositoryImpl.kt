package com.adan.pokapp.data.repository

import com.adan.pokapp.data.datasource.remote.model.*
import com.adan.pokapp.data.datasource.remote.network.PokemonRemoteDataSource
import com.adan.pokapp.domain.model.*
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(private val remoteDataSource: PokemonRemoteDataSource) : PokemonRepository {

    override suspend fun getAllPokemonsFromRemote(): List<Pokemon> {
        val response = remoteDataSource.getPokemonsFromApi()
        return response.toListPokemon()
    }

    override suspend fun getAbilitiesFromRemote(id: Long): List<Abilities> {
        val response = remoteDataSource.getAbilitiesFromApi(id)
        return response.toListAbilities()
    }

    override suspend fun getAbilityFromRemote(id: Long): List<AbilityEffect> {
        val response = remoteDataSource.getAbilityFromApi(id)
        return response.toListAbilityEffect()
    }

    override suspend fun getMoveFromRemote(id: Long): List<MoveEffect> {
        val response = remoteDataSource.getMoveFromApi(id)
        return response.toListMoveEffect()
    }

    override suspend fun getImageFromRemote(id: Long): Sprites {
        val response = remoteDataSource.getImageFromApi(id)
        return response.toSprites()
    }
}