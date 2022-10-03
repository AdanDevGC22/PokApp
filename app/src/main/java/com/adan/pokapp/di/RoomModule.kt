package com.adan.pokapp.di

import android.content.Context
import androidx.room.Room
import com.adan.pokapp.data.datasource.local.database.PokemonDatabase
import com.adan.pokapp.utils.Constants.POKEMON_DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, PokemonDatabase::class.java, POKEMON_DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideItemsDatabase(pokemonDatabase: PokemonDatabase) = pokemonDatabase.pokemonDao()
}