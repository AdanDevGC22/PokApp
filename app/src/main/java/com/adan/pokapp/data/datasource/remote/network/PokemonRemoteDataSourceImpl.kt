package com.adan.pokapp.data.datasource.remote.network

import com.adan.pokapp.data.datasource.remote.model.*
import javax.inject.Inject

class PokemonRemoteDataSourceImpl @Inject constructor(private val pokemonApi: PokemonApi) : PokemonRemoteDataSource {

    override suspend fun getPokemonsFromApi(): List<PokemonModel> {
        return pokemonApi.getPokemons().let { it.body()!!.result }
    }

    override suspend fun getAbilitiesFromApi(id: Long): List<AbilitiesModel> {
        return pokemonApi.getAbilities(id).let { it.body()!!.abilitiesModel }
    }

    override suspend fun getAbilityFromApi(id: Long): List<AbilityEffectModel> {
        return pokemonApi.getAbility(id).let { it.body()!!.abilityEffects }
    }

    override suspend fun getMoveFromApi(id: Long): List<MoveEffectModel> {
        return pokemonApi.getMove(id).let { it.body()!!.moveEffects }
    }

    override suspend fun getImageFromApi(id: Long): SpritesModel {
        return pokemonApi.getPokemonImage(id).let { it.body()!!.spritesModel }
    }
}