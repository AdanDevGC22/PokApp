package com.adan.pokapp.data.datasource.remote.model

import com.adan.pokapp.domain.model.Move
import com.google.gson.annotations.SerializedName

data class MoveModel(@SerializedName("name") val name: String?)
fun MoveModel.toMove() = Move(this.name)
