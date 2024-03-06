package com.example.myhexagonalpokedex.infrastucture.pokeapiadapter.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PokeApiPokemonDTO {
    @JsonProperty("name")
    private String name;
    @JsonProperty("url")
    private String url;

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
}
