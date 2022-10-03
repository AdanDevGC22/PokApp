package com.adan.pokapp.utils

import androidx.room.TypeConverter
import com.adan.pokapp.data.datasource.local.entity.AbilityEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ConvertersRoom {

    @TypeConverter
    fun fromGroupTaskMemberOwnerEntity(value: AbilityEntity): String {
        val gson = Gson()
        val type = object : TypeToken<AbilityEntity>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toGroupTaskMemberOwnerEntity(value: String): AbilityEntity {
        val gson = Gson()
        val type = object : TypeToken<AbilityEntity>() {}.type
        return gson.fromJson(value, type)
    }
}