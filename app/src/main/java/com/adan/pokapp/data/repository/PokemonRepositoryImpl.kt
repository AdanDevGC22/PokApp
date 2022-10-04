package com.adan.pokapp.data.repository

import com.adan.pokapp.data.datasource.local.PokemonLocalDataSource
import com.adan.pokapp.data.datasource.local.entity.*
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

    override suspend fun getAllAbilitiesFromRemote(): List<Ability> {
        val response = remoteDataSource.getAbilitiesFromApi()
        return response.toListAbility()
    }

    override suspend fun getAllMovesFromRemote(): List<Move> {
        val response = remoteDataSource.getMovesFromApi()
        return response.toListMove()
    }

    override suspend fun getAllPokemonsFromLocal(): List<Pokemon> {
        val response = localDataSource.getAllPokemons()
        return response.toListPokemon()
    }

    override suspend fun insertAllPokemons(pokemons: List<Pokemon>) {
        localDataSource.insertAllPokemons(pokemons.toListPokemonEntity())
    }

    override suspend fun getAllAbilitiesFromLocal(): List<Ability> {
        val response = localDataSource.getAllAbilities()
        return response.toListAbility()
    }

    override suspend fun insertAllAbilities(abilities: List<Ability>) {
        localDataSource.insertAllAbilities(abilities.toListAbilityEntity())
    }

    override suspend fun getAllMovesFromLocal(): List<Move> {
        val response = localDataSource.getAllMoves()
        return response.toListMove()
    }

    override suspend fun insertAllMoves(moves: List<Move>) {
        localDataSource.insertAllMoves(moves.toListMoveEntity())
    }
}