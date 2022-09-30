package com.adan.pokapp.data.repository

import com.adan.pokapp.data.datasource.remote.model.PokemonModel

interface PokemonRepository {

    suspend fun getAllPokemonsFromRemote(): List<PokemonModel>
}