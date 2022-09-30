package com.adan.pokapp.data.datasource.remote.response

import com.adan.pokapp.data.datasource.remote.model.SpritesModel
import com.google.gson.annotations.SerializedName

data class FormResponse(@SerializedName("sprites") val spritesModel: SpritesModel)
