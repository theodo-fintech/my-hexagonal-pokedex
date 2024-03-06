package com.example.myhexagonalpokedex.infrastucture.pokeapiadapter.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonDetailsDTO {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("abilities")
    private List<AbilityDTO> abilities;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<AbilityDTO> getAbilities() {
        return abilities;
    }
}
