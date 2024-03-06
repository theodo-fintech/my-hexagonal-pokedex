package com.example.myhexagonalpokedex.domain.pokemon;

public class CapturePokemonUseCase {
    private final PokemonApiFetcher pokemonApiFetcher;

    public CapturePokemonUseCase(PokemonApiFetcher pokemonApiFetcher) {
        this.pokemonApiFetcher = pokemonApiFetcher;
    }

    public void capture(Integer pokemonId) {
        final Pokemon pokemonToCapture = pokemonApiFetcher.findById(pokemonId);
    }
}
