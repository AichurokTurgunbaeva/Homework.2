package com.company.exceptions;

public class JsonFileNotFoundException extends RuntimeException{
    public JsonFileNotFoundException(String message) {
        super(message);

    }
}

