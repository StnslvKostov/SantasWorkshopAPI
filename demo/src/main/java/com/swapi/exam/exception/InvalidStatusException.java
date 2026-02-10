package com.swapi.exam.exception;

public class InvalidStatusException extends RuntimeException{

    public InvalidStatusException(String message) {
        super(message);
    }
}
