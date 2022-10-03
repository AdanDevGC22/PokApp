package com.adan.pokapp.data.datasource.remote.model

import com.adan.pokapp.domain.model.Abilities
import com.google.gson.annotations.SerializedName

data class AbilitiesModel(
    @SerializedName("id") val id: Long?,
    @SerializedName("ability") val ability: AbilityModel?,
    @SerializedName("is_hidden") val isHidden: Boolean?
)

fun AbilitiesModel.toAbilities() = Abilities(
    this.id,
    this.ability?.toAbility(),
    this.isHidden
)

fun List<AbilitiesModel>.toListAbilities() = map { it.toAbilities() }