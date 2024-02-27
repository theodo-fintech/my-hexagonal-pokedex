package com.example.myhexagonalpokedex.infrastucture.pokeapiadapter;


import com.example.myhexagonalpokedex.infrastucture.pokeapiadapter.dto.PokeApiPokemonDTOList;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.springframework.stereotype.Component;

@Component
public class PokeApiHttpClient {
    private static final String POKEAPI_BASE_URL = "https://pokeapi.co/api/v2";

    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    public PokeApiHttpClient(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
        this.httpClient = HttpClient.newHttpClient();
    }


    public PokeApiPokemonDTOList findTopTwenty() {
        final String uri = POKEAPI_BASE_URL + "/pokemon";
        return get(uri, PokeApiPokemonDTOList.class);
    }

    private <ResponseBody> ResponseBody get(String uri, Class<ResponseBody> responseBodyClass) {
        try {
            final HttpRequest.Builder requestBuilder = HttpRequest.newBuilder(URI.create(uri))
                    .GET();
            final HttpResponse<byte[]> httpResponse = this.httpClient.send(requestBuilder.build(),
                    HttpResponse.BodyHandlers.ofByteArray());
            final int statusCode = httpResponse.statusCode();
            if (statusCode == 200) {
                return objectMapper.readValue(httpResponse.body(), responseBodyClass);
            }
            final String message = String.format("Error fetching resources from %s", uri);
            throw new RuntimeException(message);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
