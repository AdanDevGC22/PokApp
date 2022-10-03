package com.adan.pokapp.domain

import com.adan.pokapp.data.repository.PokemonRepository
import com.adan.pokapp.di.IoDispatcher
import com.adan.pokapp.domain.model.Abilities
import com.adan.pokapp.domain.model.Pokemon
import com.adan.pokapp.utils.InternetCheck
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PokemonUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) {

    suspend fun getAllPokemons(): List<Pokemon> = withContext(ioDispatcher) {
        val pokemonsLocal = pokemonRepository.getAllPokemonsFromLocal()
        if (InternetCheck.isNetworkAvailable() && pokemonsLocal.isNullOrEmpty()) {
            val pokemonsRemote = pokemonRepository.getAllPokemonsFromRemote()
            pokemonRepository.getAbilitiesFromRemote()
            pokemonRepository.insertAllPokemons(pokemonsRemote)
            pokemonRepository.getAllPokemonsFromLocal()
        } else {
            pokemonsLocal
        }
    }

   /* suspend fun getImagePokemon(): String = withContext(ioDispatcher) {
        return@withContext pokemonRepository.getImageFromRemote()
    }*/
}