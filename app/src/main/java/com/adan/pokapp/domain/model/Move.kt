package com.adan.pokapp.domain.model

import com.adan.pokapp.data.datasource.local.entity.MoveEntity

data class Move(val id: Long?, val name: String?, val url: String?)
fun Move.toMoveEntity() = MoveEntity(this.id, this.name, this.url)
fun List<Move>.toListMoveEntity() = map { it.toMoveEntity() }
