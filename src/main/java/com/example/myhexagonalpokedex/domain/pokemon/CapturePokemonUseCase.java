package com.example.myhexagonalpokedex.domain.pokemon;

public class CapturePokemonUseCase {
    private final PokemonApiFetcher pokemonApiFetcher;
    private final PokemonRepositorySaver pokemonRepositorySaver;

    public CapturePokemonUseCase(PokemonApiFetcher pokemonApiFetcher, PokemonRepositorySaver pokemonRepositorySaver) {
        this.pokemonApiFetcher = pokemonApiFetcher;
        this.pokemonRepositorySaver = pokemonRepositorySaver;
    }

    public void capture(Integer pokemonId) {
        final Pokemon pokemonToCapture = pokemonApiFetcher.findById(pokemonId);
        pokemonRepositorySaver.save(pokemonToCapture);
    }
}
