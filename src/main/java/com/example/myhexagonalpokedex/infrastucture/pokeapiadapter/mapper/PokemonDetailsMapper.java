package com.example.myhexagonalpokedex.infrastucture.pokeapiadapter.mapper;

import com.example.myhexagonalpokedex.domain.pokemon.Pokemon;
import com.example.myhexagonalpokedex.infrastucture.pokeapiadapter.dto.PokemonDetailsDTO;

public interface PokemonDetailsMapper {
    static Pokemon fromDtoToDomain(PokemonDetailsDTO pokemonDetailsDTO) {
        return new Pokemon(
                pokemonDetailsDTO.getId(),
                pokemonDetailsDTO.getName(),
                pokemonDetailsDTO.getAbilities()
                        .getFirst()
                        .getAbility()
                        .getName()
        );
    }
}
