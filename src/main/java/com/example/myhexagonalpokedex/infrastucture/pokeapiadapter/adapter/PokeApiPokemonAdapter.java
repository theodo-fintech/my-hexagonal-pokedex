package com.example.myhexagonalpokedex.infrastucture.pokeapiadapter.adapter;

import com.example.myhexagonalpokedex.domain.pokemon.CapturablePokemon;
import com.example.myhexagonalpokedex.domain.pokemon.PokemonApiFetcher;
import com.example.myhexagonalpokedex.infrastucture.pokeapiadapter.PokeApiHttpClient;
import com.example.myhexagonalpokedex.infrastucture.pokeapiadapter.dto.PokeApiPokemonDTOList;
import com.example.myhexagonalpokedex.infrastucture.pokeapiadapter.mapper.PokemonMapper;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class PokeApiPokemonAdapter implements PokemonApiFetcher {

    private final PokeApiHttpClient pokeApiHttpClient;

    public PokeApiPokemonAdapter(PokeApiHttpClient pokeApiHttpClient) {
        this.pokeApiHttpClient = pokeApiHttpClient;
    }

    @Override
    public List<CapturablePokemon> findTopTwenty() {
        final PokeApiPokemonDTOList pokeApiPokemonDTOList = pokeApiHttpClient.findTopTwenty();
        return PokemonMapper.fromDtoListToDomainList(pokeApiPokemonDTOList);
    }
}
