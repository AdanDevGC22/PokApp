package com.adan.pokapp.data.datasource.remote.model

import com.adan.pokapp.domain.model.Ability
import com.google.gson.annotations.SerializedName

data class AbilityModel(
    var id: Long?,
    @SerializedName("name") val name: String?,
    @SerializedName("url") val url: String?
) {
    fun getIdAbility(): Long? {
        val urlPart: Array<String>? = url?.split("/")?.toTypedArray()
        return urlPart?.get(urlPart.size - 2)?.toLong()
    }
}

fun AbilityModel.toAbility() = Ability(this.id, this.name, this.url)
fun List<AbilityModel>.toListAbility() = map { it.toAbility() }