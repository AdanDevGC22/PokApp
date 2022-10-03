package com.adan.pokapp.ui.view.fragment

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.adan.pokapp.R
import com.adan.pokapp.data.datasource.remote.response.PokemonResponse
import com.adan.pokapp.databinding.FragmentPokemonBinding
import com.adan.pokapp.domain.model.Abilities
import com.adan.pokapp.domain.model.Pokemon
import com.adan.pokapp.ui.view.adapter.PokemonAdapter
import com.adan.pokapp.ui.viewModel.PokemonViewModel
import com.adan.pokapp.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PokemonFragment : Fragment() {

    private lateinit var binding: FragmentPokemonBinding
    private lateinit var pokemonAdapter: PokemonAdapter

    private val viewModel: PokemonViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentPokemonBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setPokemonsAdapter()
        viewModel.onPokemon()
        setObservers()
    }

    private fun setPokemonsAdapter() {
        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            binding.recyclerViewPokemons.layoutManager = GridLayoutManager(
                requireContext(), 2,
                GridLayoutManager.VERTICAL, false
            )
        } else {
            binding.recyclerViewPokemons.layoutManager = GridLayoutManager(
                requireContext(), 5,
                GridLayoutManager.VERTICAL, false
            )
        }
        pokemonAdapter = PokemonAdapter(arrayListOf())
        binding.recyclerViewPokemons.addItemDecoration(
            DividerItemDecoration(
                binding.recyclerViewPokemons.context,
                (binding.recyclerViewPokemons.layoutManager as LinearLayoutManager).orientation
            )
        )

        binding.recyclerViewPokemons.adapter = pokemonAdapter
        binding.recyclerViewPokemons.setHasFixedSize(true)
        binding.recyclerViewPokemons.itemAnimator = null


        binding.scrollView.setOnScrollChangeListener(NestedScrollView.OnScrollChangeListener { v, _, scrollY, _, _ ->
            if (scrollY == v.getChildAt(0).measuredHeight - v.measuredHeight) {
                binding.progressBar.visibility = View.VISIBLE
            }
        })
    }

    private fun setObservers() {
        viewModel.pokemon.observe(viewLifecycleOwner, { pokemonResponse ->
            when (pokemonResponse.status) {
                Resource.Status.LOADING -> {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.recyclerViewPokemons.visibility = View.GONE
                }
                Resource.Status.SUCCESS -> {
                    lifecycleScope.launch {
                        binding.progressBar.visibility = View.GONE
                        if (!pokemonResponse.data.isNullOrEmpty()) renderList(pokemonResponse.data)
                        binding.recyclerViewPokemons.visibility = View.VISIBLE
                    }
                }
                Resource.Status.ERROR -> {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(requireContext(), pokemonResponse.message, Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    private fun renderList(data: List<Pokemon>) {
        val list = ArrayList<Pokemon>()
        list.addAll(data)
        pokemonAdapter.submitList(list)
    }
}