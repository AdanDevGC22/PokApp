package com.adan.pokapp.domain

import com.adan.pokapp.data.datasource.remote.model.PokemonModel
import com.adan.pokapp.data.repository.PokemonRepository
import com.adan.pokapp.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PokemonUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) {

    suspend fun getAllPokemons(): List<PokemonModel> = withContext(ioDispatcher) {
        pokemonRepository.getAllPokemonsFromRemote()
    }
}