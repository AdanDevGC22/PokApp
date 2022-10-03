package com.adan.pokapp.data.repository

import com.adan.pokapp.data.datasource.local.PokemonLocalDataSource
import com.adan.pokapp.data.datasource.local.entity.toListPokemon
import com.adan.pokapp.data.datasource.remote.model.*
import com.adan.pokapp.data.datasource.remote.network.PokemonRemoteDataSource
import com.adan.pokapp.domain.model.*
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val remoteDataSource: PokemonRemoteDataSource,
    private val localDataSource: PokemonLocalDataSource
) : PokemonRepository {

    override suspend fun getAllPokemonsFromRemote(): List<Pokemon> {
        val response = remoteDataSource.getPokemonsFromApi()
        return response.toListPokemon()
    }

    override suspend fun getAbilitiesFromRemote(): List<Abilities> {
        val response = remoteDataSource.getAbilitiesFromApi()
        return response.toListAbilities()
    }

    override suspend fun getMovesFromRemote(): List<Moves> {
        val response = remoteDataSource.getMovesFromApi()
        return response.toListMoves()
    }

    override suspend fun getAbilityFromRemote(): List<AbilityEffect> {
        val response = remoteDataSource.getAbilityFromApi()
        return response.toListAbilityEffect()
    }

    override suspend fun getMoveFromRemote(): List<MoveEffect> {
        val response = remoteDataSource.getMoveFromApi()
        return response.toListMoveEffect()
    }

  /*  override suspend fun getImageFromRemote(): String {
        return remoteDataSource.getImageFromApi()
    }*/

    override suspend fun getAllPokemonsFromLocal(): List<Pokemon> {
        return localDataSource.getAllPokemons().toListPokemon()
    }

    override suspend fun insertAllPokemons(pokemons: List<Pokemon>) {
        localDataSource.insertAllPokemons(pokemons.toListPokemonEntity())
    }
}