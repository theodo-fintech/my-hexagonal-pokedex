package com.example.myhexagonalpokedex.application.restapiadapter.controller;

import com.example.myhexagonalpokedex.application.restapiadapter.dto.PokemonDTO;
import com.example.myhexagonalpokedex.application.restapiadapter.mapper.PokemonMapper;
import com.example.myhexagonalpokedex.domain.pokemon.CapturablePokemonService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {
    private final CapturablePokemonService capturablePokemonService;

    public PokemonController(CapturablePokemonService capturablePokemonService) {
        this.capturablePokemonService = capturablePokemonService;
    }

    @GetMapping("/capturable")
    List<PokemonDTO> findCapturablePokemon() {
        return capturablePokemonService
                .findAllInTopTwenty()
                .stream()
                .map(PokemonMapper::fromDomainToDto)
                .toList();
    }
}
