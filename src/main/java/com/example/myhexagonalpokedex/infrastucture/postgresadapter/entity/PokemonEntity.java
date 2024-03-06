package com.example.myhexagonalpokedex.infrastucture.postgresadapter.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pokemons")
public class PokemonEntity {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "ability", nullable = false)
    private String ability;

    public PokemonEntity(Integer id, String name, String ability) {
        this.id = id;
        this.name = name;
        this.ability = ability;
    }

    public PokemonEntity() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAbility() {
        return ability;
    }
}
