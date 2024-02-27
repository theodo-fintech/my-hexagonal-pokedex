package com.example.myhexagonalpokedex.infrastucture.pokeapiadapter.mapper;

import static java.lang.Integer.parseInt;

import com.example.myhexagonalpokedex.domain.pokemon.Pokemon;
import com.example.myhexagonalpokedex.infrastucture.pokeapiadapter.dto.PokeApiPokemonDTO;
import com.example.myhexagonalpokedex.infrastucture.pokeapiadapter.dto.PokeApiPokemonDTOList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface PokemonMapper {

    static List<Pokemon> fromDtoListToDomainList(PokeApiPokemonDTOList pokeApiPokemonDTOList) {
        List<Pokemon> pokemons = new ArrayList<>();
        Arrays.stream(pokeApiPokemonDTOList.getPokemons()).forEach(pokeApiPokemonDTO -> {
            final int pokemonId = extractIdFromPokemonUrl(pokeApiPokemonDTO);
            pokemons.add(new Pokemon(pokemonId, pokeApiPokemonDTO.getName(), null));
        });
        return pokemons;
    }

    private static int extractIdFromPokemonUrl(PokeApiPokemonDTO pokeApiPokemonDTO) {
        final String[] splitUrl = pokeApiPokemonDTO.getUrl().split("/");
        return parseInt(splitUrl[splitUrl.length - 1]);
    }
}
