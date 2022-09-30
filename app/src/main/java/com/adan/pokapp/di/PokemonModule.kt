package com.adan.pokapp.di

import com.adan.pokapp.data.datasource.remote.network.PokemonRemoteDataSource
import com.adan.pokapp.data.datasource.remote.network.PokemonRemoteDataSourceImpl
import com.adan.pokapp.data.repository.PokemonRepository
import com.adan.pokapp.data.repository.PokemonRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PokemonModule {

    @Singleton
    @Provides
    fun provideRemoteDataSource(pokemonRemoteDataSourceImpl: PokemonRemoteDataSourceImpl): PokemonRemoteDataSource = pokemonRemoteDataSourceImpl

    @Singleton
    @Provides
    fun provideRepository(pokemonRepositoryImpl: PokemonRepositoryImpl): PokemonRepository = pokemonRepositoryImpl
}