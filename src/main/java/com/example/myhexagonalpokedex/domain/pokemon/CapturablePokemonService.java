package com.example.myhexagonalpokedex.domain.pokemon;

import java.util.List;

public class CapturablePokemonService {
    private final PokemonApiFetcher pokemonApiFetcher;

    public CapturablePokemonService(PokemonApiFetcher pokemonApiFetcher) {
        this.pokemonApiFetcher = pokemonApiFetcher;
    }

    public List<Pokemon> findAll() {
        return pokemonApiFetcher.findAll();
    }
}
