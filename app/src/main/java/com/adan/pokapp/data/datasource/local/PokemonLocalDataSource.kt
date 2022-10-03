package com.adan.pokapp.data.datasource.local

import com.adan.pokapp.data.datasource.local.entity.PokemonEntity

interface PokemonLocalDataSource {

    suspend fun getAllPokemons(): List<PokemonEntity>
    suspend fun insertAllPokemons(pokemons: List<PokemonEntity>)
}