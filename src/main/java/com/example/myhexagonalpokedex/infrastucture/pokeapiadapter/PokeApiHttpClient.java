package com.example.myhexagonalpokedex.infrastucture.pokeapiadapter;


import com.example.myhexagonalpokedex.core.exception.ExceptionCode;
import com.example.myhexagonalpokedex.core.exception.MyHexagonalPokedexException;
import com.example.myhexagonalpokedex.infrastucture.pokeapiadapter.dto.PokeApiPokemonDTOList;
import com.example.myhexagonalpokedex.infrastucture.pokeapiadapter.dto.PokemonDetailsDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PokeApiHttpClient {


    private final String pokeapiBaseUrl;
    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    public PokeApiHttpClient(@Value("${infrastructure.pokeapi.app.api}") String pokeapiBaseUrl, ObjectMapper objectMapper) {
        this.pokeapiBaseUrl = pokeapiBaseUrl;
        this.objectMapper = objectMapper;
        this.httpClient = HttpClient.newHttpClient();
    }


    public PokeApiPokemonDTOList findTopTwenty() {
        final String uri = pokeapiBaseUrl + "/pokemon";
        return get(uri, PokeApiPokemonDTOList.class);
    }

    public PokemonDetailsDTO findById(Integer pokemonId) {
        final String uri = pokeapiBaseUrl + "/pokemon/" + pokemonId;
        return get(uri, PokemonDetailsDTO.class);
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
            throw buildPokeApiHttpStatusCodeException(httpResponse);
        } catch (IOException | InterruptedException e) {
            throw buildErrorWhileExecutingHttpRequestException(uri, e);
        }
    }

    private MyHexagonalPokedexException buildPokeApiHttpStatusCodeException(HttpResponse<byte[]> httpResponse) {
        byte[] responseBody = httpResponse.body();
        String rootErrorMessage = new String(responseBody, StandardCharsets.UTF_8);
        final String message = String.format(
                "Error while calling pokeapi uri %s, root error message is %s",
                httpResponse.uri(),
                rootErrorMessage
        );
        return new MyHexagonalPokedexException(ExceptionCode.POKEAPI_ERROR, message);
    }

    private static MyHexagonalPokedexException buildErrorWhileExecutingHttpRequestException(String uri, Throwable rootException) {
        final String message = String.format("Error while calling %s", uri);
        return new MyHexagonalPokedexException(ExceptionCode.ERROR_WHILE_EXECUTING_HTTP_REQUEST, message, rootException);
    }
}
