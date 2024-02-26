package com.example.myhexagonalpokedex.bootstrap;

import com.example.myhexagonalpokedex.domain.pokemon.CapturablePokemonService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainConfiguration {

    @Bean
    public CapturablePokemonService capturablePokemonService() {
        return new CapturablePokemonService();
    }
}
