package com.example.myhexagonalpokedex.infrastucture.postgresadapter.adapter;

import com.example.myhexagonalpokedex.core.exception.ExceptionCode;
import com.example.myhexagonalpokedex.core.exception.MyHexagonalPokedexException;
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
        try {
            return pokemonRepository.findAll().stream().map(PokemonEntityMapper::fromEntityToDomain).toList();
        } catch (Exception e) {
            final String message = "Error while fetching pokemons in database";
            throw new MyHexagonalPokedexException(ExceptionCode.POSTGRES_FIND_POKEMON_ERROR, message, e);
        }
    }
}
