package com.example.myhexagonalpokedex.domain.pokemon;

import java.util.List;

public class CapturablePokemonUseCase {
    private final PokemonApiFetcher pokemonApiFetcher;

    public CapturablePokemonUseCase(PokemonApiFetcher pokemonApiFetcher) {
        this.pokemonApiFetcher = pokemonApiFetcher;
    }

    public List<CapturablePokemon> findAllInTopTwenty() {
        return pokemonApiFetcher.findTopTwenty();
    }
}
