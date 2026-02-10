package com.swapi.exam.exception;

public class UsernameExistException extends RuntimeException{

    public UsernameExistException(){
        super("Username already exists");
    }
}
