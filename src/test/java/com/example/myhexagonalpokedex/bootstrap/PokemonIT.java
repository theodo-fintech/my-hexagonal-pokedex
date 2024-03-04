package com.example.myhexagonalpokedex.bootstrap;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

class PokemonIT extends MyHexagonalPokedexIT {
    @Autowired
    MockMvc mockMvc;

    @Test
    void should_retrieve_capturable_pokemons_within_top_twenty() throws Exception {
        mockMvc
                .perform(MockMvcRequestBuilders.get("/pokemon/capturable"));
    }
}
