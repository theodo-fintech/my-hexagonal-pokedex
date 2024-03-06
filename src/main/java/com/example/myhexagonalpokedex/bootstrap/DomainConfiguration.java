package com.example.myhexagonalpokedex.bootstrap;

import com.example.myhexagonalpokedex.domain.pokemon.CapturablePokemonUseCase;
import com.example.myhexagonalpokedex.domain.pokemon.CapturePokemonUseCase;
import com.example.myhexagonalpokedex.domain.pokemon.PokemonApiFetcher;
import com.example.myhexagonalpokedex.domain.pokemon.PokemonRepositoryFetcher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainConfiguration {

    @Bean
    public CapturablePokemonUseCase capturablePokemonService(PokemonApiFetcher pokemonApiFetcher,
                                                             PokemonRepositoryFetcher pokemonRepositoryFetcher) {
        return new CapturablePokemonUseCase(pokemonApiFetcher, pokemonRepositoryFetcher);
    }

    @Bean
    public CapturePokemonUseCase capturePokemonUseCase(PokemonApiFetcher pokemonApiFetcher) {
        return new CapturePokemonUseCase(pokemonApiFetcher);
    }
}
