package com.example.myhexagonalpokedex.domain.pokemon;

import java.util.List;

public interface PokemonApiFetcher {
    List<Pokemon> findTopTwenty();
}
