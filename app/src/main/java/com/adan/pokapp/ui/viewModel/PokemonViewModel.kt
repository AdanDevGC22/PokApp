package com.adan.pokapp.ui.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adan.pokapp.domain.PokemonUseCase
import com.adan.pokapp.domain.model.*
import com.adan.pokapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(private val useCase: PokemonUseCase) : ViewModel() {

    private val _pokemon = MutableLiveData<Resource<List<Pokemon>>>()
    val pokemon: LiveData<Resource<List<Pokemon>>> = _pokemon

    private val _ability = MutableLiveData<Resource<List<Ability>>>()
    val ability: LiveData<Resource<List<Ability>>> = _ability

    private val _move = MutableLiveData<Resource<List<Move>>>()
    val move: LiveData<Resource<List<Move>>> = _move

    fun onPokemon() {
        viewModelScope.launch {
            _pokemon.postValue(Resource.loading())
            val pokemons = useCase.getAllPokemons()
            if (!pokemons.isNullOrEmpty()) {
                _pokemon.postValue(Resource.success(pokemons))
            } else {
                _pokemon.postValue(Resource.error("Sin internet"))
            }
        }
    }

    fun onAbility() {
        viewModelScope.launch {
          _ability.postValue(Resource.loading())
            val abilities = useCase.getAllAbilities()
            if (!abilities.isNullOrEmpty()) {
                _ability.postValue(Resource.success(abilities))
            } else {
                _ability.postValue(Resource.error("Sin internet"))
            }
        }
    }

    fun onMove() {
        viewModelScope.launch {
            _move.postValue(Resource.loading())
            val moves = useCase.getAllMoves()
            if (!moves.isNullOrEmpty()) {
                _move.postValue(Resource.success(moves))
            } else {
                _move.postValue(Resource.error("Sin internet"))
            }
        }
    }
}