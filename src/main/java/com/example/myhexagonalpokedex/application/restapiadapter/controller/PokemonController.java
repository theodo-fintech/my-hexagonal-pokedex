package com.example.myhexagonalpokedex.application.restapiadapter.controller;

import com.example.myhexagonalpokedex.application.restapiadapter.dto.CapturablePokemonDTO;
import com.example.myhexagonalpokedex.application.restapiadapter.mapper.PokemonMapper;
import com.example.myhexagonalpokedex.domain.pokemon.CapturablePokemonUseCase;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {
    private final CapturablePokemonUseCase capturablePokemonUseCase;

    public PokemonController(CapturablePokemonUseCase capturablePokemonUseCase) {
        this.capturablePokemonUseCase = capturablePokemonUseCase;
    }

    @GetMapping("/capturable")
    List<CapturablePokemonDTO> findCapturablePokemon() {
        return capturablePokemonUseCase
                .findAllInTopTwenty()
                .stream()
                .map(PokemonMapper::fromDomainToDto)
                .toList();
    }
}
