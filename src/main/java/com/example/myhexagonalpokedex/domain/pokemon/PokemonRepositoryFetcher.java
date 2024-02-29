package com.example.myhexagonalpokedex.domain.pokemon;

import java.util.List;

public interface PokemonRepositoryFetcher {
    List<Pokemon> findAll();
}
