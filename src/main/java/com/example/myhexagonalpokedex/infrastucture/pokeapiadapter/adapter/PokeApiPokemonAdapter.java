package com.example.myhexagonalpokedex.infrastucture.pokeapiadapter.adapter;

import com.example.myhexagonalpokedex.domain.pokemon.Pokemon;
import com.example.myhexagonalpokedex.domain.pokemon.PokemonApiFetcher;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class PokeApiPokemonAdapter implements PokemonApiFetcher {
    @Override
    public List<Pokemon> findAll() {
        return List.of();
    }
}
