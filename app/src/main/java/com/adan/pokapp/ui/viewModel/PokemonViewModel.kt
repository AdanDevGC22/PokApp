package com.adan.pokapp.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adan.pokapp.domain.PokemonUseCase
import com.adan.pokapp.domain.model.Abilities
import com.adan.pokapp.domain.model.Pokemon
import com.adan.pokapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(private val useCase: PokemonUseCase) : ViewModel() {

    private val _pokemon = MutableLiveData<Resource<List<Pokemon>>>()
    val pokemon: LiveData<Resource<List<Pokemon>>> = _pokemon

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

   /* fun getImagePokemon() : String {
        var image = ""
        viewModelScope.launch {
           image = useCase.getImagePokemon()
        }
        return image
    }*/
}