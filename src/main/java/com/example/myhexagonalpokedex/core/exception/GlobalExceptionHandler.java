package com.example.myhexagonalpokedex.core.exception;

import com.example.myhexagonalpokedex.application.restapiadapter.dto.ErrorDTO;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({MyHexagonalPokedexException.class})
    protected ResponseEntity<Object> handleMyHexagonalPokedexException(MyHexagonalPokedexException ex) {
        return handleGenericException(ex);
    }

    protected ResponseEntity<Object> handleGenericException(
            MyHexagonalPokedexException myHexagonalPokedexException
    ) {
        var errorDto = new ErrorDTO(
                myHexagonalPokedexException.exceptionCode.toString(),
                myHexagonalPokedexException.getMessage()
        );

        return ResponseEntity
                .status(myHexagonalPokedexException.exceptionCode.getHttpStatusCode())
                .body(List.of(errorDto));
    }
}
