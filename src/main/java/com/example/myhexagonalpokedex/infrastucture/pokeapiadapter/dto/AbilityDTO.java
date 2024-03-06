package com.example.myhexagonalpokedex.infrastucture.pokeapiadapter.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AbilityDTO {
    @JsonProperty("ability")
    private AbilityDetailsDTO ability;

    public AbilityDetailsDTO getAbility() {
        return ability;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class AbilityDetailsDTO {
        @JsonProperty("name")
        private String name;

        public String getName() {
            return name;
        }
    }
}
