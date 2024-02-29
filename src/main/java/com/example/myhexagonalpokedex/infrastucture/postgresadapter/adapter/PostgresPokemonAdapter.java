package com.example.myhexagonalpokedex.infrastucture.postgresadapter.adapter;

import com.example.myhexagonalpokedex.domain.pokemon.Pokemon;
import com.example.myhexagonalpokedex.domain.pokemon.PokemonRepositoryFetcher;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class PostgresPokemonAdapter implements PokemonRepositoryFetcher {
    @Override
    public List<Pokemon> findAll() {
        return List.of();
    }
}
