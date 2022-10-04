package com.adan.pokapp.data.datasource.remote.model

import com.adan.pokapp.domain.model.Move
import com.google.gson.annotations.SerializedName

data class MoveModel(
    var id: Long?,
    @SerializedName("name") val name: String?,
    @SerializedName("url") val url: String?
)

fun MoveModel.toMove() = Move(this.id, this.name, this.url)
fun List<MoveModel>.toListMove() = map { it.toMove() }
