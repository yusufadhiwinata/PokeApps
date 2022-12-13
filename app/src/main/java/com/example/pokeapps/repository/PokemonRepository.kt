package com.example.pokeapps.repository

import com.example.pokeapps.data.remote.PokeApi
import com.example.pokeapps.data.remote.response.Pokemon
import com.example.pokeapps.data.remote.response.PokemonList
import com.example.pokeapps.utils.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class PokemonRepository @Inject constructor(
    private val api: PokeApi
) {
    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        val response = try {
            api.getPokemonList(limit, offset)
        } catch (e: Exception) {
            return Resource.Error("An Unknown error occurred")
        }
        return Resource.Success(response)
    }
    suspend fun getPokemonInfo(pokemonName :String): Resource<Pokemon> {
        val response = try {
            api.getPokemonInfo(pokemonName)
        } catch (e: Exception) {
            return Resource.Error("An Unknown error occurred")
        }
        return Resource.Success(response)
    }


}