package com.adan.pokapp.data.datasource.remote.model

import com.adan.pokapp.domain.model.Sprites
import com.google.gson.annotations.SerializedName

data class SpritesModel(@SerializedName("front_default") val imagePokemon: String?)
fun SpritesModel.toSprites() = Sprites(this.imagePokemon)