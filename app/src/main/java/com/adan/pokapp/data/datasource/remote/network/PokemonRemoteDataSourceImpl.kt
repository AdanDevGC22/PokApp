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

    override suspend fun getAbilitiesFromApi(): List<AbilityModel> {
        return pokemonApi.getAbilities().let { it.body()!!.result }
    }

    override suspend fun getMovesFromApi(): List<MoveModel> {
        return pokemonApi.getMoves().let { it.body()!!.result }
    }

    /*override suspend fun getAbilitiesFromApi(): List<AbilitiesModel> {
        return pokemonApi.getPokemon(getId()!!.size.toLong()).let { it.body()!!.abilitiesModel }
    }

    override suspend fun getMovesFromApi(): List<MovesModel> {
        return pokemonApi.getPokemon(getId()!!.size.toLong()).let { it.body()!!.movesModel }
    }*/

  /*  override suspend fun getAbilityFromApi(): List<AbilityEffectModel> {
        val ability = pokemonApi.getAbility(getId()!!.size.toLong()).let {
            it.body()!!.abilityEffects
        }
        ability.map {
            it.id = getId()?.size?.toLong()
            for (i in ability.indices) {
                it.id = getId()?.get(i)
            }
        }
        return ability
    }

    override suspend fun getMoveFromApi(): List<MoveEffectModel> {
        return pokemonApi.getMove(getId()!!.size.toLong()).let { it.body()!!.moveEffects }
    }*/

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