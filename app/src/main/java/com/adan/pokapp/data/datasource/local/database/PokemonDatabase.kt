package com.adan.pokapp.data.datasource.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.adan.pokapp.data.datasource.local.dao.PokemonDao
import com.adan.pokapp.data.datasource.local.entity.PokemonEntity
import com.adan.pokapp.utils.ConvertersRoom

@Database(entities = [PokemonEntity::class], version = 1)
@TypeConverters(ConvertersRoom::class)
abstract class PokemonDatabase : RoomDatabase() {

    abstract fun pokemonDao(): PokemonDao
}