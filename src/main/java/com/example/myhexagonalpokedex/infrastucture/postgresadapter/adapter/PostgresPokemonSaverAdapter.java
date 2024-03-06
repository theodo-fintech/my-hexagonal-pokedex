package com.example.myhexagonalpokedex.infrastucture.postgresadapter.adapter;

import com.example.myhexagonalpokedex.core.exception.ExceptionCode;
import com.example.myhexagonalpokedex.core.exception.MyHexagonalPokedexException;
import com.example.myhexagonalpokedex.domain.pokemon.Pokemon;
import com.example.myhexagonalpokedex.domain.pokemon.PokemonRepositorySaver;
import com.example.myhexagonalpokedex.infrastucture.postgresadapter.mapper.PokemonEntityMapper;
import com.example.myhexagonalpokedex.infrastucture.postgresadapter.repository.PokemonRepository;
import org.springframework.stereotype.Component;

@Component
public class PostgresPokemonSaverAdapter implements PokemonRepositorySaver {

    private final PokemonRepository pokemonRepository;

    public PostgresPokemonSaverAdapter(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    @Override
    public void save(Pokemon pokemon) {
        try {
            pokemonRepository.save(PokemonEntityMapper.fromDomainToEntity(pokemon));
        } catch (Exception e) {
            throw new MyHexagonalPokedexException(
                    ExceptionCode.POSTGRES_SAVE_POKEMON_ERROR,
                    String.format("Error saving pokemon with id '%s', name '%s', ability '%s'",
                            pokemon.id(),
                            pokemon.name(),
                            pokemon.ability()),
                    e
            );
        }
    }
}
