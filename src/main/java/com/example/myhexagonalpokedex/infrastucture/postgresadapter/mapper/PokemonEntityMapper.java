package com.example.myhexagonalpokedex.infrastucture.postgresadapter.mapper;

import com.example.myhexagonalpokedex.domain.pokemon.Pokemon;
import com.example.myhexagonalpokedex.infrastucture.postgresadapter.entity.PokemonEntity;

public interface PokemonEntityMapper {

    static Pokemon fromEntityToDomain(PokemonEntity pokemonEntity) {
        return new Pokemon(pokemonEntity.getId(), pokemonEntity.getName(), pokemonEntity.getAbility());
    }

    static PokemonEntity fromDomainToEntity(Pokemon pokemon) {
        return new PokemonEntity(pokemon.id(), pokemon.name(), pokemon.ability());
    }
}
