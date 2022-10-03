package com.adan.pokapp.data.datasource.local

import com.adan.pokapp.data.datasource.local.dao.PokemonDao
import com.adan.pokapp.data.datasource.local.entity.PokemonEntity
import javax.inject.Inject

class PokemonLocalDataSourceImpl @Inject constructor(private val pokemonDao: PokemonDao) : PokemonLocalDataSource {

    override suspend fun getAllPokemons(): List<PokemonEntity> {
        return pokemonDao.getAllPokemons()
    }

    override suspend fun insertAllPokemons(pokemons: List<PokemonEntity>) {
        pokemonDao.insertAllPokemons(pokemons)
    }
}