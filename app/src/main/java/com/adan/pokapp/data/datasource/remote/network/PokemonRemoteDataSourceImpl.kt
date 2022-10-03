package com.adan.pokapp.data.datasource.remote.network

import android.util.Log
import com.adan.pokapp.data.datasource.remote.model.*
import javax.inject.Inject

class PokemonRemoteDataSourceImpl @Inject constructor(private val pokemonApi: PokemonApi) :
    PokemonRemoteDataSource {

    private suspend fun getId(): List<Long?>? {
        return pokemonApi.getPokemons().body()?.result?.map { it.getIdPokemon() }
    }

    override suspend fun getPokemonsFromApi(): List<PokemonModel> {
        return pokemonApi.getPokemons().let { it.body()!!.result }
    }

    override suspend fun getAbilitiesFromApi(): List<AbilitiesModel> {
        val hola = pokemonApi.getPokemon(getId()!!.size.toLong()).let { it.body()!!.abilitiesModel }
        Log.e("Hola", "Aqui esta: $hola")
        return hola
    }

    override suspend fun getMovesFromApi(): List<MovesModel> {
        return pokemonApi.getPokemon(getId()!!.size.toLong()).let { it.body()!!.movesModel }
    }

    override suspend fun getAbilityFromApi(): List<AbilityEffectModel> {
        return pokemonApi.getAbility(getId()!!.size.toLong()).let { it.body()!!.abilityEffects }
    }

    override suspend fun getMoveFromApi(): List<MoveEffectModel> {
        return pokemonApi.getMove(getId()!!.size.toLong()).let { it.body()!!.moveEffects }
    }

    /*override suspend fun getImageFromApi(): String {
        return pokemonApi.getPokemon(getId()!!.size.toLong()).body().let { response ->
            response?.otherModel?.artworkModel?.imagePokemon.toString()
        }
    }*/
}


/*override suspend fun getImageFromApi(): String {
        val hola = pokemonApi.getPokemonImage(getId()!!.size.toLong()).body().let { it?.spritesModel?.imagePokemon.toString() }
        Log.e("Hola", "ID2: $hola")
        return hola
    }*/