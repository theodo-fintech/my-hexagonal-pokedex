package com.example.myhexagonalpokedex.core.exception;

public enum ExceptionCode {
    POKEAPI_ERROR(500),
    ERROR_WHILE_EXECUTING_HTTP_REQUEST(500);

    private final Integer httpStatusCode;

    ExceptionCode(Integer httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    public Integer getHttpStatusCode() {
        return httpStatusCode;
    }
}
