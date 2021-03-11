package br.com.forttiori.exceptionhandlers;

import br.com.forttiori.exceptions.BusLineAlreadyRegistredException;
import br.com.forttiori.exceptions.BusLinesNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.*;


@RequiredArgsConstructor
@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(StringIndexOutOfBoundsException.class)
    @ResponseStatus(BAD_REQUEST)
    public StandardError erroAoExtrairIdOuCodigo(StringIndexOutOfBoundsException e) {
        return StandardError.builder()
                .dataHora(LocalDateTime.now())
                .error(BAD_REQUEST.getReasonPhrase())
                .message(e.getMessage())
                .status(BAD_REQUEST.value())
                .build();
    }

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    @ResponseStatus(BAD_REQUEST)
    public StandardError erroAoExtrairNome(StringIndexOutOfBoundsException e) {
        return StandardError.builder()
                .dataHora(LocalDateTime.now())
                .error(BAD_REQUEST.getReasonPhrase())
                .message(e.getMessage())
                .status(BAD_REQUEST.value())
                .build();
    }

    @ExceptionHandler(BusLineAlreadyRegistredException.class)
    @ResponseStatus(BAD_REQUEST)
    public StandardError erroAoExtrairNome(BusLineAlreadyRegistredException e) {
        return StandardError.builder()
                .dataHora(LocalDateTime.now())
                .error(BAD_REQUEST.getReasonPhrase())
                .message(e.getMessage())
                .status(BAD_REQUEST.value())
                .build();
    }

    @ExceptionHandler(BusLinesNotFoundException.class)
    @ResponseStatus(NOT_FOUND)
    public StandardError noBusLines(BusLinesNotFoundException e) {
        return StandardError.builder()
                .dataHora(LocalDateTime.now())
                .error(NOT_FOUND.getReasonPhrase())
                .message(e.getMessage())
                .status(NOT_FOUND.value())
                .build();
    }


}
