package com.example.myhexagonalpokedex.infrastucture.pokeapiadapter.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PokeApiPokemonDTOList {
    @JsonProperty("results")
    private PokeApiPokemonDTO[] pokemons;

    public PokeApiPokemonDTO[] getPokemons() {
        return pokemons;
    }
}
