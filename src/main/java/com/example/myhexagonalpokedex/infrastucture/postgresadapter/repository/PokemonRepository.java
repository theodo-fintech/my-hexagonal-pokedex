package com.example.myhexagonalpokedex.infrastucture.postgresadapter.repository;

import com.example.myhexagonalpokedex.infrastucture.postgresadapter.entity.PokemonEntity;
import jakarta.annotation.Nonnull;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonRepository extends JpaRepository<PokemonEntity, Integer> {

    @Override
    @Nonnull
    List<PokemonEntity> findAll();
}
