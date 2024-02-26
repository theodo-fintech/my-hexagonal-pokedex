package com.example.myhexagonalpokedex.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.myhexagonalpokedex")
public class MyHexagonalPokedexApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyHexagonalPokedexApplication.class, args);
    }
}
