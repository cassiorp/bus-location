package br.com.forttiori.exceptions;

public class BusLinesNotFoundException extends RuntimeException{

    public BusLinesNotFoundException(String message) {
        super(message);
    }
}
