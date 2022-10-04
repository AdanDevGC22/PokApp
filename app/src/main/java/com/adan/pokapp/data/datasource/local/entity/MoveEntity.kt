package com.adan.pokapp.data.datasource.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.adan.pokapp.domain.model.Move

@Entity(tableName = "move_table")
data class MoveEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Long?,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "url") val url: String?
)

fun MoveEntity.toMove() = Move(this.id, this.name, this.url)
fun List<MoveEntity>.toListMove() = map { it.toMove() }
