package com.example.myhexagonalpokedex.bootstrap;

import com.example.myhexagonalpokedex.domain.pokemon.CapturablePokemonService;
import com.example.myhexagonalpokedex.domain.pokemon.PokemonApiFetcher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainConfiguration {

    @Bean
    public CapturablePokemonService capturablePokemonService(PokemonApiFetcher pokemonApiFetcher) {
        return new CapturablePokemonService(pokemonApiFetcher);
    }
}
