package com.example.myhexagonalpokedex.infrastucture.postgresadapter.mapper;

import com.example.myhexagonalpokedex.domain.pokemon.Pokemon;
import com.example.myhexagonalpokedex.infrastucture.postgresadapter.entity.PokemonEntity;

public interface PokemonEntityMapper {

    static Pokemon fromEntityToDomain(PokemonEntity pokemonEntity) {
        return new Pokemon(pokemonEntity.getId(), pokemonEntity.getName(), pokemonEntity.getAbility());
    }
}
