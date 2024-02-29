package com.example.myhexagonalpokedex.domain.pokemon;

import java.util.List;

public class CapturablePokemonUseCase {
    private final PokemonApiFetcher pokemonApiFetcher;
    private final PokemonRepositoryFetcher pokemonRepositoryFetcher;

    public CapturablePokemonUseCase(PokemonApiFetcher pokemonApiFetcher, PokemonRepositoryFetcher pokemonRepositoryFetcher) {
        this.pokemonApiFetcher = pokemonApiFetcher;
        this.pokemonRepositoryFetcher = pokemonRepositoryFetcher;
    }

    public List<CapturablePokemon> findAllInTopTwenty() {
        return pokemonApiFetcher.findTopTwenty();
    }
}
