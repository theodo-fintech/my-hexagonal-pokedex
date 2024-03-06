package com.example.myhexagonalpokedex.bootstrap;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

class PokemonIT extends MyHexagonalPokedexIT {
    @Autowired
    MockMvc mockMvc;

    @Test
    void should_retrieve_capturable_pokemons_within_top_twenty_without_owned_pokemon() throws Exception {
        wireMockServer.stubFor(
                get(
                        urlPathEqualTo("/pokemon"))
                        .willReturn(aResponse().withBodyFile("pokeapi_stubs/get_top_twenty_pokemons.json")));
        mockMvc
                .perform(MockMvcRequestBuilders.get("/pokemon/capturable"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("bulbasaur"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].name").value("ivysaur"))
                .andExpect(jsonPath("$[2].id").value(3))
                .andExpect(jsonPath("$[2].name").value("venusaur"));
    }
}
