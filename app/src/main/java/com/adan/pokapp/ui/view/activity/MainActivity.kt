package com.adan.pokapp.ui.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import com.adan.pokapp.R
import com.adan.pokapp.ui.viewModel.PokemonViewModel
import com.adan.pokapp.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: PokemonViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.onPokemon()
        viewModel.pokemon.observe(this, { pokemonResponse ->
            when (pokemonResponse.status) {
                Resource.Status.LOADING -> {
                    Toast.makeText(this, "Cargando", Toast.LENGTH_SHORT).show()
                }
                Resource.Status.SUCCESS -> {
                    Log.e("Hola", "Aqui esta: ${pokemonResponse.data}")
                }
                Resource.Status.ERROR -> {
                    Toast.makeText(this, pokemonResponse.message, Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
}