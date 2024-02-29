package com.example.myhexagonalpokedex.infrastucture.postgresadapter.adapter;

import com.example.myhexagonalpokedex.domain.pokemon.Pokemon;
import com.example.myhexagonalpokedex.domain.pokemon.PokemonRepositoryFetcher;
import com.example.myhexagonalpokedex.infrastucture.postgresadapter.mapper.PokemonEntityMapper;
import com.example.myhexagonalpokedex.infrastucture.postgresadapter.repository.PokemonRepository;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class PostgresPokemonAdapter implements PokemonRepositoryFetcher {

    private final PokemonRepository pokemonRepository;

    public PostgresPokemonAdapter(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    @Override
    public List<Pokemon> findAll() {
        return pokemonRepository.findAll().stream().map(PokemonEntityMapper::fromEntityToDomain).toList();
    }
}
