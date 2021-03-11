package br.com.forttiori.exceptions;

public class BusLineAlreadyRegistredException extends RuntimeException {

    public BusLineAlreadyRegistredException(String message) {
        super(message);
    }
}
