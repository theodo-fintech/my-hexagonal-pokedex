package com.example.myhexagonalpokedex.application.restapiadapter.controller;

import com.example.myhexagonalpokedex.application.restapiadapter.dto.CapturablePokemonDTO;
import com.example.myhexagonalpokedex.application.restapiadapter.dto.CapturePokemonDTO;
import com.example.myhexagonalpokedex.application.restapiadapter.mapper.PokemonMapper;
import com.example.myhexagonalpokedex.domain.pokemon.CapturablePokemonUseCase;
import com.example.myhexagonalpokedex.domain.pokemon.CapturePokemonUseCase;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pokemon")
@Tag(name = "Pokemon")
public class PokemonController {
    private final CapturablePokemonUseCase capturablePokemonUseCase;
    private final CapturePokemonUseCase capturePokemonUseCase;

    public PokemonController(CapturablePokemonUseCase capturablePokemonUseCase, CapturePokemonUseCase capturePokemonUseCase) {
        this.capturablePokemonUseCase = capturablePokemonUseCase;
        this.capturePokemonUseCase = capturePokemonUseCase;
    }

    @GetMapping("/capturable")
    List<CapturablePokemonDTO> findCapturablePokemon() {
        return capturablePokemonUseCase
                .findAllInTopTwenty()
                .stream()
                .map(PokemonMapper::fromDomainToDto)
                .toList();
    }

    @PostMapping
    void capturePokemon(@RequestBody CapturePokemonDTO capturePokemonDTO) {
        capturePokemonUseCase.capture(capturePokemonDTO.id());
    }
}
