package com.adan.pokapp.ui.view.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import coil.imageLoader
import coil.request.ImageRequest
import com.adan.pokapp.R
import com.adan.pokapp.databinding.ItemPokemonBinding
import com.adan.pokapp.domain.model.Abilities
import com.adan.pokapp.domain.model.Pokemon
import com.adan.pokapp.domain.model.toPokemonModel
import com.adan.pokapp.utils.Constants.IMAGE_URL

class PokemonAdapter(private val pokemon: PokemonClickListener) :
    RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>() {

    private lateinit var context: Context
    private lateinit var recyclerView: RecyclerView
    private var itemPokemon: ArrayList<Pokemon> = ArrayList()
    private var pokemonPosition = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonAdapter.PokemonViewHolder {
        context = parent.context
        return PokemonViewHolder(
            ItemPokemonBinding.inflate(
                LayoutInflater.from(context)
            )
        )
    }

    override fun onBindViewHolder(holder: PokemonAdapter.PokemonViewHolder, position: Int) {
        val item = itemPokemon[position]
        item.let {
            holder.apply {
                bind(item, context)
                itemView.tag = item
            }
        }
        holder.itemView.setOnClickListener {
            pokemon.clickOnItem(item, holder.itemView)
            pokemonPosition = holder.adapterPosition + 1
            Log.e("Position", "Aqui: $pokemonPosition")
        }

    }

    override fun getItemCount(): Int = itemPokemon.size

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        this.recyclerView = recyclerView
    }

    fun submitList(itemList: ArrayList<Pokemon>) {
        this.itemPokemon.clear()
        this.itemPokemon.addAll(itemList)
        notifyItemInserted(itemPokemon.size - 1)
    }

    fun getPosition(): Int {
        Log.e("Position", "Aqui2: $pokemonPosition")
        return pokemonPosition
    }

    inner class PokemonViewHolder(private val binding: ItemPokemonBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(pokemon: Pokemon, context: Context) {
            val imageRequest = ImageRequest.Builder(context)
                .data(pokemon.toPokemonModel().getImageUrl())
                .crossfade(true)
                .size(1280, 720)
                .target(
                    onStart = {
                        binding.imageViewRecipes.setImageResource(R.drawable.ic_time)
                    },
                    onSuccess = { avatar ->
                        binding.progressBar.visibility = View.GONE
                        binding.imageViewRecipes.scaleType = ImageView.ScaleType.CENTER_CROP
                        binding.imageViewRecipes.setImageDrawable(avatar)
                    },
                    onError = {
                        binding.progressBar.visibility = View.GONE
                        binding.imageViewRecipes.setImageResource(R.drawable.ic_error)
                    }
                ).build()
            context.imageLoader.enqueue(imageRequest)
            binding.textViewName.text = pokemon.name
        }
    }

    interface PokemonClickListener {
        fun clickOnItem(data: Pokemon, card: View)
    }
}