package com.adan.pokapp.data.datasource.remote.model

import com.adan.pokapp.domain.model.Ability
import com.google.gson.annotations.SerializedName

data class AbilityModel(@SerializedName("name") val name: String?)
fun AbilityModel.toAbility() = Ability(this.name)