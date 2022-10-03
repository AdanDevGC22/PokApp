package com.adan.pokapp.data.datasource.remote.model

import com.adan.pokapp.domain.model.Moves
import com.google.gson.annotations.SerializedName

data class MovesModel(@SerializedName("move") val moveModel: MoveModel?)
fun MovesModel.toMoves() = Moves(this.moveModel?.toMove())
fun List<MovesModel>.toListMoves() = map { it.toMoves() }