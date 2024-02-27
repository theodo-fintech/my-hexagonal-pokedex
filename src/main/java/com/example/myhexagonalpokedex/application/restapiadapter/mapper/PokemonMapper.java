package com.example.myhexagonalpokedex.application.restapiadapter.mapper;

import com.example.myhexagonalpokedex.application.restapiadapter.dto.CapturablePokemonDTO;
import com.example.myhexagonalpokedex.domain.pokemon.CapturablePokemon;

public interface PokemonMapper {
    static CapturablePokemonDTO fromDomainToDto(CapturablePokemon capturablePokemon) {
        return new CapturablePokemonDTO(capturablePokemon.id(), capturablePokemon.name());
    }
}
