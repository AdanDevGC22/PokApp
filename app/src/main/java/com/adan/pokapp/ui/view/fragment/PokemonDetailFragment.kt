package com.adan.pokapp.ui.view.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.adan.pokapp.R

class PokemonDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pokemon_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setContent()
    }

    private fun setContent() {
        arguments?.let { bundle ->
            Log.e("JJR", "pokemonImage: ${bundle.getString("pokemonImage")}")
            Log.e("JJR", "pokemonName: ${bundle.getString("pokemonName")}")
            Log.e("JJR", "abilityName: ${bundle.getString("abilityName")}")
            Log.e("JJR", "moveName: ${bundle.getString("moveName")}")
        }
    }
}