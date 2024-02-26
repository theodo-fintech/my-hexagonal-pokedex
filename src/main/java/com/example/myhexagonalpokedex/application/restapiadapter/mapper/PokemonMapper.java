package com.example.myhexagonalpokedex.application.restapiadapter.mapper;

import com.example.myhexagonalpokedex.application.restapiadapter.dto.PokemonDTO;
import com.example.myhexagonalpokedex.domain.pokemon.Pokemon;

public interface PokemonMapper {
    static PokemonDTO fromDomainToDto(Pokemon pokemon) {
        return new PokemonDTO(pokemon.id(), pokemon.name(), pokemon.ability());
    }
}
