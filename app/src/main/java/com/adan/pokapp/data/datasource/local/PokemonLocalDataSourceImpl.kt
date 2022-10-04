package com.adan.pokapp.data.datasource.local

import com.adan.pokapp.data.datasource.local.dao.PokemonDao
import com.adan.pokapp.data.datasource.local.entity.*
import javax.inject.Inject

class PokemonLocalDataSourceImpl @Inject constructor(private val pokemonDao: PokemonDao) : PokemonLocalDataSource {

    override suspend fun getAllPokemons(): List<PokemonEntity> {
        return pokemonDao.getAllPokemons()
    }

    override suspend fun insertAllPokemons(pokemons: List<PokemonEntity>) {
        pokemonDao.insertAllPokemons(pokemons)
    }

    override suspend fun getAllAbilities(): List<AbilityEntity> {
        return pokemonDao.getAllAbilities()
    }

    override suspend fun insertAllAbilities(abilities: List<AbilityEntity>) {
        pokemonDao.insertAllAbilities(abilities)
    }

    override suspend fun getAllMoves(): List<MoveEntity> {
        return pokemonDao.getAllMoves()
    }

    override suspend fun insertAllMoves(moves: List<MoveEntity>) {
        pokemonDao.insertAllMoves(moves)
    }
}