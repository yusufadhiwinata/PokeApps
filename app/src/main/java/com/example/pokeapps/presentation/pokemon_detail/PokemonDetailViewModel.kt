package com.example.pokeapps.presentation.pokemon_detail

import androidx.lifecycle.ViewModel
import com.example.pokeapps.data.remote.response.Pokemon
import com.example.pokeapps.repository.PokemonRepository
import com.example.pokeapps.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val repository: PokemonRepository
) : ViewModel() {

    suspend fun getPokemonInfo(pokemonName :String):Resource<Pokemon>{
        return repository.getPokemonInfo(pokemonName)
    }
}