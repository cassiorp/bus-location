package br.com.forttiori.exceptionhandlers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;


@RequiredArgsConstructor
@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(StringIndexOutOfBoundsException.class)
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    public StandardError erroAoExtrairIdOuCodigo(StringIndexOutOfBoundsException e) {
        return StandardError.builder()
                .dataHora(LocalDateTime.now())
                .error(INTERNAL_SERVER_ERROR.getReasonPhrase())
                .message(e.getMessage())
                .status(INTERNAL_SERVER_ERROR.value())
                .build();
    }

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    public StandardError erroAoExtrairNome(StringIndexOutOfBoundsException e) {
        return StandardError.builder()
                .dataHora(LocalDateTime.now())
                .error(INTERNAL_SERVER_ERROR.getReasonPhrase())
                .message(e.getMessage())
                .status(INTERNAL_SERVER_ERROR.value())
                .build();
    }


}
