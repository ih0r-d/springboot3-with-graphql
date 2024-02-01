package com.example.exceptions;

public class ApplianceNotFoundException extends RuntimeException{
    public ApplianceNotFoundException(String message) {
        super(message);
    }
}
