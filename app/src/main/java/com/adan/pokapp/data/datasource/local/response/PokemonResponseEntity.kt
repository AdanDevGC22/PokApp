package com.adan.pokapp.data.datasource.local.response

import com.adan.pokapp.data.datasource.local.entity.AbilitiesEntity
import com.adan.pokapp.data.datasource.local.entity.MovesEntity

data class PokemonResponseEntity(
    val idPokemon: Long?,
    val abilitiesEntity: List<AbilitiesEntity>,
    val movesEntity: List<MovesEntity>?
)