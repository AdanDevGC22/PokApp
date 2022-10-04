package com.adan.pokapp.domain

import com.adan.pokapp.data.repository.PokemonRepository
import com.adan.pokapp.di.IoDispatcher
import com.adan.pokapp.domain.model.Ability
import com.adan.pokapp.domain.model.Move
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
            pokemonRepository.insertAllPokemons(pokemonsRemote)
            pokemonRepository.getAllPokemonsFromLocal()
        } else {
            pokemonsLocal
        }
    }

    suspend fun getAllAbilities(): List<Ability> = withContext(ioDispatcher) {
        val abilityLocal = pokemonRepository.getAllAbilitiesFromLocal()
        if (InternetCheck.isNetworkAvailable() && abilityLocal.isNullOrEmpty()) {
            val abilityRemote = pokemonRepository.getAllAbilitiesFromRemote()
            pokemonRepository.insertAllAbilities(abilityRemote)
            pokemonRepository.getAllAbilitiesFromLocal()
        } else {
            abilityLocal
        }
    }

    suspend fun getAllMoves(): List<Move> = withContext(ioDispatcher) {
        val moveLocal = pokemonRepository.getAllMovesFromLocal()
        if (InternetCheck.isNetworkAvailable() && moveLocal.isNullOrEmpty()) {
            val moveRemote = pokemonRepository.getAllMovesFromRemote()
            pokemonRepository.insertAllMoves(moveRemote)
            pokemonRepository.getAllMovesFromLocal()
        } else {
            moveLocal
        }
    }
}